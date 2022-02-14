package kz.iitu.itse1909.borangaziyev.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class CustomerTest {
    @Mock
    List<Booking> bookings;
    @InjectMocks
    Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = customer.toString();
        Assertions.assertEquals("Customer: ID: 0 Email: null First Name: null Last Name: null Is Vip: false", result);
    }

    @Test
    void testSetCustomerId() {
        customer.setCustomerId(0L);
    }

    @Test
    void testSetFirstName() {
        customer.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        customer.setLastName("lastName");
    }

    @Test
    void testSetEmail() {
        customer.setEmail("email");
    }

    @Test
    void testSetVip() {
        customer.setVip(true);
    }

    @Test
    void testSetBookings() {
        customer.setBookings(Arrays.<Booking>asList(new Booking()));
    }

    @Test
    void testEquals() {
        boolean result = customer.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = customer.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = customer.hashCode();
        Customer cust = customer;
        Assertions.assertEquals(cust.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme