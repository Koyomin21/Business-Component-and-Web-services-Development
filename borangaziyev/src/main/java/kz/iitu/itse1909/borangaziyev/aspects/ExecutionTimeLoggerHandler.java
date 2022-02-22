package kz.iitu.itse1909.borangaziyev.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeLoggerHandler {

    @Pointcut("@annotation(kz.iitu.itse1909.borangaziyev.aspects.ExecutionTimeLogger)")
    public void allAnnotatedClassMethods() {}

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void allRepositoryClassMethods() {}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void allServiceClassMethods() {}

    @Around("allAnnotatedClassMethods() || allServiceClassMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        long startTime = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Caught an Exception in method: " + joinPoint.getSignature().getName());
            throwable.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println(joinPoint.getSignature().getName() + " was executed in " + endTime + " milliseconds");
            return proceed;
        }

    }
}
