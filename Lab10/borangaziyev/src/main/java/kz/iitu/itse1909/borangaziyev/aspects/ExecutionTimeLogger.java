package kz.iitu.itse1909.borangaziyev.aspects;

import java.lang.annotation.*;

@Target({ElementType.TYPE , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExecutionTimeLogger {
}
