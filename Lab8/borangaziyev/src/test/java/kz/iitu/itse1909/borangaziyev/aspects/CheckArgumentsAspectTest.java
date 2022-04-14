package kz.iitu.itse1909.borangaziyev.aspects;

import org.aspectj.lang.JoinPoint;
import org.hibernate.mapping.Join;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class CheckArgumentsAspectTest {
    CheckArgumentsAspect checkArgumentsAspect = new CheckArgumentsAspect();

    @Test
    void testAllAnnotatedMethods() {
        checkArgumentsAspect.allAnnotatedMethods();
    }

    @Test
    void testMovieServiceMethods() {
        checkArgumentsAspect.movieServiceMethods();
    }

    @Test
    void testCustomerServiceMethods() {
        checkArgumentsAspect.customerServiceMethods();
    }

    @Test
    void testBookingServiceMethods() {
        checkArgumentsAspect.bookingServiceMethods();
    }

    @Test
    void testCheckArguments() {
        checkArgumentsAspect.checkArguments(null);
    }

    @Test
    void testLoggingAfter() {
        checkArgumentsAspect.loggingAfter(null);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme