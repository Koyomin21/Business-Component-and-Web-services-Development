package kz.iitu.itse1909.borangaziyev.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=CheckSeatValidator.class)
@Documented
public @interface CheckSeat  {
    String message() default "Seat should have seat number and Row!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
