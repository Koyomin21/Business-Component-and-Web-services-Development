package kz.iitu.itse1909.borangaziyev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletContext;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class BookingControllerTest {
    @Mock
    BookingService bookingService;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ServletContext servletContext;
    @Mock
    Logger log;
    @InjectMocks
    BookingController bookingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBookings() {
        when(bookingService.getAllBookings()).thenReturn(Arrays.<Booking>asList());

        ResponseEntity<List<Booking>> result = ResponseEntity.ok(Arrays.<Booking>asList());

        Assertions.assertEquals("<200 OK OK,[],[]>", result.toString());
    }

    @Test
    void testGetPaidBookingsByCustomerId() {
        when(bookingService.getPaidBookingsPagination(anyLong(), anyInt(), anyInt(), anyString())).thenReturn(Arrays.<Booking>asList());

        ResponseEntity<List<Booking>> result = bookingController.getPaidBookingsByCustomerId(0L, 0, 0, "sortBy");
        Assertions.assertEquals("<200 OK OK,[],[]>", result.toString());
    }




}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme