package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

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
        Assertions.assertEquals("Booking: ID: 0 Customer: null null Session: null nullSeat: Row: 0, Number: 0 Is Paid: false", result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme