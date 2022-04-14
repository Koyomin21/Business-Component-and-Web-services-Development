package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepository;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;
import org.springframework.util.Assert;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        when(bookingRepository.findAll()).thenReturn(Arrays.<Booking>asList(new Booking()));

        List<Booking> result = bookingService.getAllBookings();
        Assertions.assertEquals(Arrays.<Booking>asList(new Booking()), result);
    }

    @Test
    void testGetPaidBookingsByCustomerId() {
        Customer customer = new Customer();
        Customer customer2 = new Customer();

        Booking booking = new Booking();

        booking.setPaid(true);
        customer.setFirstName("First NAme ");
        customer.setBookings(Arrays.asList(booking));
        customer2.setBookings(Arrays.asList());

        when(customerRepository.findById(1l)).thenReturn(java.util.Optional.of(customer));
        when(customerRepository.findById(0l)).thenReturn(java.util.Optional.of(customer2));

        List<Booking> result = bookingService.getPaidBookingsByCustomerId(1L);
        List<Booking> result2 = bookingService.getPaidBookingsByCustomerId(0L);

        Assertions.assertEquals(Arrays.<Booking>asList(booking), result);
        Assertions.assertEquals(Arrays.<Booking>asList(), result2);
    }

    @Test
    void testGetBookingsByMovieSessionId() {
        MovieSession session = new MovieSession();
        MovieSession session2 = new MovieSession();
        Booking booking = new Booking();

        session.setBookings(Arrays.asList(booking));
        session2.setBookings(Arrays.asList());

        when(sessionRepository.findById(1l)).thenReturn(java.util.Optional.of(session));
        when(sessionRepository.findById(0l)).thenReturn(java.util.Optional.of(session2));


        List<Booking> result = bookingService.getBookingsByMovieSessionId(1L);
        List<Booking> result2 = bookingService.getBookingsByMovieSessionId(0L);

        Assertions.assertEquals(Arrays.<Booking>asList(booking), result);
        Assertions.assertEquals(Arrays.<Booking>asList(), result2);
    }

    @Test
    void testGetBookingsAfterDate() {
        when(bookingRepository.getBookingsByBookingDateAfter(any())).thenReturn(Arrays.<Booking>asList(new Booking()));

        List<Booking> result = bookingService.getBookingsAfterDate(LocalDate.of(2022, Month.MARCH, 6));
        Assertions.assertEquals(Arrays.<Booking>asList(new Booking()), result);
    }

    @Test
    void testGetBookingsBeforeDate() {
        when(bookingRepository.getBookingsByBookingDateBefore(any())).thenReturn(Arrays.<Booking>asList(new Booking()));

        List<Booking> result = bookingService.getBookingsBeforeDate(LocalDate.of(2022, Month.MARCH, 6));
        Assertions.assertEquals(Arrays.<Booking>asList(new Booking()), result);
    }

    @Test
    void testGetPaidBookings() {
        when(bookingRepository.findPaidBookings()).thenReturn(Arrays.<Booking>asList(new Booking()));

        List<Booking> result = bookingService.getPaidBookings();
        Assertions.assertEquals(Arrays.<Booking>asList(new Booking()), result);
    }

    @Test
    void testGetPaidBookingsPagination() {
        Booking booking = new Booking();
        booking.setCustomer(new Customer());
        booking.setSession(new MovieSession());
        booking.setSeat(new Seat());

        List<Booking> bookingList = Arrays.asList(booking);
        Pageable paging = PageRequest.of(1, 1, Sort.by("isPaid"));
        Page<Booking> bookingPage = new PageImpl<Booking>(bookingList);
        System.out.println(bookingPage.getContent());

        when(bookingRepository.findAll(paging)).thenReturn(bookingPage);
//        doReturn(bookingPage).when(bookingRepository.findAll(paging));

        when(bookingService.getPaidBookingsPagination(1l, 1, 1, "isPaid")).thenReturn(bookingList);

        List<Booking> result = bookingService.getPaidBookingsPagination(1l, 1, 1, "isPaid");


        Assertions.assertEquals(bookingList, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme