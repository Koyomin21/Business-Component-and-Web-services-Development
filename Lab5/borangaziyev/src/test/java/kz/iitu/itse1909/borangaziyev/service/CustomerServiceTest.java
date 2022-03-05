package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepo;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    MovieRepo movieRepo;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> result = customerService.getAllCustomers();
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
    }

    @Test
    void testGetAllCustomersFromSession() {
        MovieSession session = new MovieSession();
        MovieSession session2 = new MovieSession();
        Booking booking = new Booking();
        booking.setCustomer(new Customer());
        session.setBookings(Arrays.asList(booking));
        session2.setBookings(Arrays.asList());

        when(movieRepo.getSessionById(0l)).thenReturn(session);
        when(movieRepo.getSessionById(1l)).thenReturn(session2);

        List<Customer> result = customerService.getAllCustomersFromSession(0L);
        List<Customer> result2 = customerService.getAllCustomersFromSession(1L);

        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
        Assertions.assertEquals(Arrays.<Customer>asList(), result2);
    }

    @Test
    void testGetVipCustomersFromSession() {
        when(movieRepo.getSessionById(anyLong())).thenReturn(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 5), LocalTime.of(8, 49, 16), LocalTime.of(8, 49, 16)));

        List<Customer> result = customerService.getVipCustomersFromSession(0L);
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme