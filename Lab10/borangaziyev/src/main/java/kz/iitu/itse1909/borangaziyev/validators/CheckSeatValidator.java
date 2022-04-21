package kz.iitu.itse1909.borangaziyev.validators;

import kz.iitu.itse1909.borangaziyev.database.Seat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckSeatValidator implements
        ConstraintValidator<CheckSeat, Seat> {

    @Override
    public boolean isValid(Seat seat, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if(seat.getNumber() == 0 || seat.getRow() == 0) result = false;

        return result;
    }
}
