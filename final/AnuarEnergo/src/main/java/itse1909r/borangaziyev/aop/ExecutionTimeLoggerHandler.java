package itse1909r.borangaziyev.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class ExecutionTimeLoggerHandler {

    @Pointcut("@annotation(itse1909r.borangaziyev.aop.ExecutionTimeLogger)")
    public void allAnnotatedClassMethods() {}

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void allRepositoryClassMethods() {}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void allServiceClassMethods() {}

    @Around("allAnnotatedClassMethods() || allServiceClassMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        if(signature.getMethod().isAnnotationPresent(Cacheable.class)) {
            log.info("The following method has been cached: "+ signature.getMethod().getName());
        }

        Object proceed = null;
        long startTime = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("Caught an Exception in method: " + joinPoint.getSignature().getName());
            throwable.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis() - startTime;
            log.info(joinPoint.getSignature().getName() + " was executed in " + endTime + " milliseconds");
            return proceed;
        }

    }

    @AfterThrowing(pointcut = "allServiceClassMethods()", throwing = "error")
    public void logAfterThrowingMethod(JoinPoint jp, Throwable error) {
        log.info("Method Signature: "  + jp.getSignature());
        log.info("Exception: "+error);
    }
}
