package itse1909r.borangaziyev.aop;

import java.lang.annotation.*;

@Target({ElementType.TYPE , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExecutionTimeLogger {
}
