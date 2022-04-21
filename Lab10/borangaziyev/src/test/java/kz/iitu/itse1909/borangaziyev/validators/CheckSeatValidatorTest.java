package kz.iitu.itse1909.borangaziyev.validators;

import kz.iitu.itse1909.borangaziyev.database.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckSeatValidatorTest {
    CheckSeatValidator checkSeatValidator = new CheckSeatValidator();


    @Test
    void testIsValid() {
        Seat notValidSeat = new Seat();
        Seat validSeat = new Seat();
        validSeat.setNumber(1);
        validSeat.setRow(2);


        boolean result = checkSeatValidator.isValid(notValidSeat, null);
        boolean result2 = checkSeatValidator.isValid(validSeat, null);

        Assertions.assertFalse(result);
        Assertions.assertTrue(result2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme