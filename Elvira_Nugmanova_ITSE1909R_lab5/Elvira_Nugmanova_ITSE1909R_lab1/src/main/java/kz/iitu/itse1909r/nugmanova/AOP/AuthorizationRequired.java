package kz.iitu.itse1909r.nugmanova.AOP;

import java.lang.annotation.*;

@Target({ElementType.TYPE , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AuthorizationRequired {
}
