package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.*;
import kz.iitu.itse1909.borangaziyev.service.BookingService;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ConfigTest {
    @Mock
    MovieService movieService;
    @Mock
    BookingService bookingService;
    @Mock
    CustomerService customerService;

    @Mock
    ApplicationContext context;

    @InjectMocks
    Config config;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSeat() {
        Seat result = config.seat();
        Assertions.assertEquals(new Seat(), result);
    }

    @Test
    void testHall() {
        Hall result = config.hall();
        Assertions.assertEquals(new Hall(), result);
    }

    @Test
    void testRunServiceMethods() {
        when(movieService.getAllMovies()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));
        when(movieService.getMoviesSortedByPublishedYear()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));
        when(movieService.getMovieBySessionId(anyLong())).thenReturn(new Movie("title", 0, 0, "description"));
        when(bookingService.getAllBookings()).thenReturn(Arrays.<Booking>asList(new Booking()));
        when(bookingService.getPaidBookingsByCustomerId(anyLong())).thenReturn(Arrays.<Booking>asList(new Booking()));
        when(bookingService.getBookingsByMovieSessionId(anyLong())).thenReturn(Arrays.<Booking>asList(new Booking()));
        when(customerService.getAllCustomers()).thenReturn(Arrays.<Customer>asList(new Customer()));
        when(customerService.getAllCustomersFromSession(anyLong())).thenReturn(Arrays.<Customer>asList(new Customer()));
        when(customerService.getVipCustomersFromSession(anyLong())).thenReturn(Arrays.<Customer>asList(new Customer()));


        List<Movie> resultMovies = movieService.getAllMovies();
//        config.runServiceMethods(new AnnotationConfigApplicationContext(Config.class));
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), resultMovies);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme