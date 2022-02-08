package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;


import java.awt.print.Book;

import static org.mockito.Mockito.*;

class CustomerConfigTest {
    @Mock
    Environment environment;
    @InjectMocks
    CustomerConfig customerConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCustomer() {
        Customer result = customerConfig.customer();
        Assertions.assertEquals(new Customer(), result);
    }

    @Test
    void testBooking() {
        Booking result = customerConfig.booking();
        Booking expected = new Booking();
        expected.setCustomer(customerConfig.customer());
        expected.setSeat(new Seat());
        expected.setSession(new MovieSession());
        Assertions.assertEquals(expected, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme