package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    MovieSessionRepository sessionRepository;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> result = customerService.getAllCustomers();
        Assertions.assertEquals(Arrays.<Customer>asList(), result);
    }

    @Test
    void testGetAllCustomersFromSession() {
        MovieSession session = new MovieSession();
        Booking booking = new Booking();
        booking.setCustomer(new Customer());
        session.setBookings(Arrays.asList(booking));

        when(sessionRepository.findById(0l)).thenReturn(java.util.Optional.of(session));

        List<Customer> result = customerService.getAllCustomersFromSession(0L);
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
    }

    @Test
    void testGetVipCustomersFromSession() {
        MovieSession session = new MovieSession();
        Booking booking = new Booking();
        booking.setCustomer(new Customer());
        session.setBookings(Arrays.asList(booking));

        when(sessionRepository.findById(0l)).thenReturn(java.util.Optional.of(session));

        List<Customer> result = customerService.getVipCustomersFromSession(0L);
        Assertions.assertEquals(Arrays.<Customer>asList(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme