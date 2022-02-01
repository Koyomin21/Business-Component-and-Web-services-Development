package kz.iitu.itse1909.borangaziyev.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.mockito.Mockito.*;

class BookingTest {
    @Mock
    Customer customer;
    @Mock
    MovieSession session;
    @Mock
    Seat seat;
    //Field bookingDate of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    Booking booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        when(customer.getFirstName()).thenReturn("getFirstNameResponse");
        when(customer.getLastName()).thenReturn("getLastNameResponse");
        when(session.getStartTime()).thenReturn(LocalTime.of(22, 50, 4));
        when(session.getEndTime()).thenReturn(LocalTime.of(22, 50, 4));
        when(seat.getRow()).thenReturn(0);
        when(seat.getNumber()).thenReturn(0);

        String result = booking.toString();
        Assertions.assertEquals("Booking: ID: 0 Customer: getFirstNameResponse getLastNameResponse Session: 22:50:04 22:50:04Seat: Row: 0, Number: 0 Is Paid: false", result);
    }

    @Test
    void testSetBookingId() {
        booking.setBookingId(0L);
    }

    @Test
    void testSetCustomer() {
        booking.setCustomer(new Customer());
    }

    @Test
    void testSetSession() {
        booking.setSession(new MovieSession());
    }

    @Test
    void testSetSeat() {
        booking.setSeat(new Seat());
    }

    @Test
    void testSetBookingDate() {
        booking.setBookingDate(LocalDate.of(2022, Month.FEBRUARY, 1));
    }

    @Test
    void testSetPaid() {
        booking.setPaid(true);
    }

    @Test
    void testEquals() {
        boolean result = booking.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = booking.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        Booking bookingLocal = booking;

        int result = booking.hashCode();

        Assertions.assertEquals(bookingLocal.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme