package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepository;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.ObjectColumnProcessor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Mock
    BookingRepository bookingRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    MovieSessionRepository sessionRepository;
    @InjectMocks
    BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBookings() {
        List<Booking> result = bookingService.getAllBookings();
        Assertions.assertEquals(Arrays.<Booking>asList(), result);
    }

    @Test
    void testGetPaidBookingsByCustomerId() {

        Customer customer = new Customer();
        customer.setBookings(Arrays.asList(new Booking()));

        System.out.println(customer);

        when(customerRepository.findById(0l)).thenReturn(Optional.of(customer));


        List<Booking> result = bookingService.getPaidBookingsByCustomerId(0L);
        Assertions.assertEquals(Arrays.<Booking>asList(), result);
    }

    @Test
    void testGetBookingsByMovieSessionId() {
        long id = 0l;

        MovieSession session = new MovieSession();
        Booking booking = new Booking();
        booking.setCustomer(new Customer());
        session.setMovie(new Movie());
        session.setBookings(Arrays.asList(booking));

        when(sessionRepository.findById(id)).thenReturn(Optional.of(session));


        List<Booking> result = bookingService.getBookingsByMovieSessionId(id);


        Assertions.assertTrue(new ArrayList<Booking>() != result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme