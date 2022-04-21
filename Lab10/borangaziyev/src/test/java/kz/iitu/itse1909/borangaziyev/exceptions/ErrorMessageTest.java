package kz.iitu.itse1909.borangaziyev.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {
    ErrorMessage errorMessage = new ErrorMessage("message", "details");
    ErrorMessage errorMessage2 = new ErrorMessage();

    @Test
    void testSetMessage() {
        errorMessage.setMessage("message");
    }

    @Test
    void testSetDetails() {
        errorMessage.setDetails("details");
    }

    @Test
    void testEquals() {
        boolean result = errorMessage.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = errorMessage.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int expected = errorMessage.hashCode();

        int result = errorMessage.hashCode();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToString() {
        String result = errorMessage.toString();
        Assertions.assertEquals("ErrorMessage(message=message, details=details)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme