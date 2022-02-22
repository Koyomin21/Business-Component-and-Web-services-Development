package kz.iitu.itse1909.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class BookingModelTest {
    //Field bookingDate of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    BookingModel bookingModel = new BookingModel();

    @Test
    void testSetBookingId() {
        bookingModel.setBookingId(0L);
    }

    @Test
    void testSetBookingDate() {
        bookingModel.setBookingDate(LocalDate.of(2022, Month.FEBRUARY, 22));
    }

    @Test
    void testSetPaid() {
        bookingModel.setPaid(true);
    }

    @Test
    void testSetCustomerId() {
        bookingModel.setCustomerId(0);
    }

    @Test
    void testSetSessionId() {
        bookingModel.setSessionId(0);
    }

    @Test
    void testSetSeatId() {
        bookingModel.setSeatId(0);
    }

    @Test
    void testEquals() {
        boolean result = bookingModel.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = bookingModel.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = bookingModel.hashCode();
        BookingModel booking = bookingModel;
        Assertions.assertEquals(booking.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = bookingModel.toString();
        Assertions.assertEquals("BookingModel(bookingId=0, bookingDate=null, isPaid=false, customerId=0, sessionId=0, seatId=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme