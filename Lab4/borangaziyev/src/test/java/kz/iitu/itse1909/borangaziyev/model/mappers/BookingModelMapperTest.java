package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.BookingModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingModelMapperTest {
    BookingModelMapper bookingModelMapper = new BookingModelMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("bookingId")).thenReturn(1l);
        when(rs.getInt("sessionId")).thenReturn(1);
        when(rs.getInt("customerId")).thenReturn(1);
        when(rs.getInt("seatId")).thenReturn(1);
        when(rs.getBoolean("isPaid")).thenReturn(true);
        when(rs.getDate("bookingDate")).thenReturn(new Date(20021012));

        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(1);
        bookingModel.setCustomerId(1);
        bookingModel.setSeatId(1);
        bookingModel.setSessionId(1);
        bookingModel.setPaid(true);
        bookingModel.setBookingDate(new Date(20021012).toLocalDate());

        BookingModel result = bookingModelMapper.mapRow(rs, 0);
        Assertions.assertEquals(bookingModel, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme