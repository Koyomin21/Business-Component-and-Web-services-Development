package kz.iitu.itse1909.borangaziyev.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Aspect
@Component
public class CheckArgumentsAspect {
    @Pointcut("@annotation(kz.iitu.itse1909.borangaziyev.aspects.CheckArguments)")
    public void allAnnotatedMethods() {}

    // all public methods of Movie Service
    @Pointcut("within(kz.iitu.itse1909.borangaziyev.service.MovieService)")
    public void movieServiceMethods() {}


    // all public methods of Customer Service
    @Pointcut("within(kz.iitu.itse1909.borangaziyev.service.CustomerService)")
    public void customerServiceMethods() {}

    // all public methods of Booking Service
    @Pointcut("within(kz.iitu.itse1909.borangaziyev.service.BookingService)")
    public void bookingServiceMethods() {}

    @Before("movieServiceMethods() || allAnnotatedMethods() || bookingServiceMethods() || customerServiceMethods()")
    public void checkArguments(JoinPoint joinPoint) {
        List<Object> args = List.of(joinPoint.getArgs());
        String methodName = joinPoint.getSignature().getName();


        // checking if there are null arguments
        if(args != null && !args.isEmpty()) {

            if(args.stream().anyMatch(a -> a == null)) {
                System.out.println("The following method: " + methodName + " has null arguments! Null arguments are listed: ");
                args.stream()
                        .map(m -> m + " ")
                        .forEach(System.out::print);
            }

            // checking if 'id' long arguments have 0
            boolean hasZeroIds = args.stream()
                    .filter(o -> o instanceof Long)
                    .anyMatch(o -> (long)o == 0);
            if(hasZeroIds) {
                System.out.println("The following method: " + methodName + " has zero id argument(s)! Zero Id arguments are : ");
                args.stream()
                        .map(m -> m + " ")
                        .forEach(System.out::print);
            }
        }


    }

    @After("allAnnotatedMethods()")
    public void checkNullResult(JoinPoint joinPoint){
        String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String targetMethod = joinPoint.getSignature().getName();
        String arg = joinPoint.getArgs()[0].toString();

        System.out.println(String.format("After Executing %s.%s with argument: %s",
                targetClass, targetMethod, arg));

    }
}
