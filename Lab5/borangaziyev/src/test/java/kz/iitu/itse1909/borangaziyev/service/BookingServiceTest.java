package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepo;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepo;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Mock
    BookingRepo bookingRepository;
    @Mock
    CustomerRepo customerRepository;
    @Mock
    MovieRepo sessionRepository;
    @InjectMocks
    BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBookings() {
        when(bookingRepository.findAll()).thenReturn(Arrays.<Booking>asList(new Booking()));

        List<Booking> result = bookingService.getAllBookings();
        Assertions.assertEquals(Arrays.<Booking>asList(new Booking()), result);
    }

    @Test
    void testGetPaidBookingsByCustomerId() {
        Customer customer = new Customer();
        Customer customer2 = new Customer();
        customer.setBookings(Arrays.<Booking>asList(new Booking()));
        customer2.setBookings(Arrays.<Booking>asList());

        when(customerRepository.findById(0l)).thenReturn(customer);
        when(customerRepository.findById(1l)).thenReturn(customer2);


        List<Booking> result = bookingService.getPaidBookingsByCustomerId(0L);
        List<Booking> result2 = bookingService.getPaidBookingsByCustomerId(1L);

        Assertions.assertEquals(Arrays.<Booking>asList(), result);
        Assertions.assertEquals(Arrays.<Booking>asList(), result2);
    }

    @Test
    void testGetBookingsByMovieSessionId() {
        MovieSession session = new MovieSession();
        session.setBookings(Arrays.<Booking>asList(new Booking()));

        MovieSession session2 = new MovieSession();
        session2.setBookings(new ArrayList<>());

        when(sessionRepository.getSessionById(0l)).thenReturn(session);
        when(sessionRepository.getSessionById(1l)).thenReturn(session2);



        List<Booking> result = bookingService.getBookingsByMovieSessionId(0L);
        List<Booking> result2 = bookingService.getBookingsByMovieSessionId(1L);

        Assertions.assertEquals(Arrays.<Booking>asList(new Booking()), result);
        Assertions.assertEquals(new ArrayList<>(), result2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme