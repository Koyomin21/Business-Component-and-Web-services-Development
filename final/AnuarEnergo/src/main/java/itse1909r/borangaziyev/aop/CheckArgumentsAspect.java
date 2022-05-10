package itse1909r.borangaziyev.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Log
public class CheckArgumentsAspect {
    @Pointcut("@annotation(itse1909r.borangaziyev.aop.CheckArguments)")
    public void allAnnotatedMethods() {}


    @Before("allAnnotatedMethods()")
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
    public void loggingAfter(JoinPoint joinPoint){
        String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String targetMethod = joinPoint.getSignature().getName();
        List<Object> args = List.of(joinPoint.getArgs());
        if(args != null && !args.isEmpty()) {
            String arg = joinPoint.getArgs()[0].toString();
            log.info(String.format("After Executing %s.%s with argument: %s",
                    targetClass, targetMethod, arg));
        } else {
            log.info(String.format("After Executing %s.%s() with no argument",
                    targetClass, targetMethod));
        }
    }

    @AfterReturning(value = "allAnnotatedMethods()", returning = "entity")
    public void checkNullResult(JoinPoint joinPoint, Object entity) throws Throwable {
        String targetMethod = joinPoint.getSignature().getName();
        if(entity == null) {
            System.out.println("The method: " + targetMethod + " returned null value!");
        }
    }






}
