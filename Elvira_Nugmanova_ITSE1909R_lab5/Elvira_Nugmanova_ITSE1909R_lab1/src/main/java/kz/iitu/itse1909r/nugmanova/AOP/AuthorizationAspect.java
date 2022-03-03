package kz.iitu.itse1909r.nugmanova.AOP;

import kz.iitu.itse1909r.nugmanova.Database.Customer;
import kz.iitu.itse1909r.nugmanova.Exceptions.NotAuthorizedException;
import kz.iitu.itse1909r.nugmanova.Service.AuthorizationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private Environment environment;

    @Pointcut("@annotation(kz.iitu.itse1909r.nugmanova.AOP.AuthorizationRequired)")
    public void authorizationAnnotatedMethods() {}




    @Before("authorizationAnnotatedMethods()")
    public void authorize(JoinPoint joinPoint) throws NotAuthorizedException {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getClass().getName();

        String email = environment.getProperty("user.email");
        String password = environment.getProperty("user.password");

        Customer customer = authorizationService.getCustomerByEmail(email);

        if(customer == null || !customer.getPassword().equals(password)) {
            throw new NotAuthorizedException("Not Authorized! No access to method: " + className + "." + methodName);
        }

        System.out.println("Successfully authorized!");
    }
}
