package kz.iitu.itse1909.borangaziyev.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

class SeatTest {
    @Mock
    Hall hall;
    @Mock
    List<Booking> bookings;
    @InjectMocks
    Seat seat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        when(hall.getName()).thenReturn("getNameResponse");

        String result = seat.toString();
        Assertions.assertEquals("Seat: Row: 0 Number: 0 Hall: getNameResponse", result);
    }

    @Test
    void testSetSeatId() {
        seat.setSeatId(0L);
    }

    @Test
    void testSetRow() {
        seat.setRow(0);
    }

    @Test
    void testSetNumber() {
        seat.setNumber(0);
    }

    @Test
    void testSetHall() {
        seat.setHall(new Hall());
    }

    @Test
    void testSetBookings() {
        seat.setBookings(Arrays.<Booking>asList(new Booking()));
    }

    @Test
    void testEquals() {
        boolean result = seat.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = seat.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = seat.hashCode();
        Seat seat2 = seat;
        Assertions.assertEquals(seat2.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme