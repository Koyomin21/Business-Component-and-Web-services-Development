package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.model.BookingModel;
import kz.iitu.itse1909.borangaziyev.model.mappers.BookingModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingJdbcRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<BookingModel> getBookingsBySessionId(long id) {
        return jdbcTemplate.query(
                "SELECT * FROM Booking b WHERE b.sessionId = :id ",
                new MapSqlParameterSource().addValue("id", id),
                new BookingModelMapper()
        );
    }

    public List<BookingModel> getBookingsByCustomerId(long id) {
        return jdbcTemplate.query(
                "SELECT * FROM Booking b WHERE b.customerId = :id ",
                new MapSqlParameterSource().addValue("id", id),
                new BookingModelMapper()
        );
    }


}
