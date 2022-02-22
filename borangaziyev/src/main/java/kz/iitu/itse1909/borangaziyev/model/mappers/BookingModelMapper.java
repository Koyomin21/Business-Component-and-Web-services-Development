package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.BookingModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingModelMapper implements RowMapper<BookingModel> {
    @Override
    public BookingModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(rs.getLong("bookingId"));
        bookingModel.setCustomerId(rs.getInt("customerId"));
        bookingModel.setSeatId(rs.getInt("seatId"));
        bookingModel.setSessionId(rs.getInt("sessionId"));
        bookingModel.setPaid(rs.getBoolean("isPaid"));
        bookingModel.setBookingDate(rs.getDate("bookingDate").toLocalDate());

        return bookingModel;
    }
}
