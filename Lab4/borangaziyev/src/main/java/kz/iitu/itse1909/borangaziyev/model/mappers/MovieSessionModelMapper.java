package kz.iitu.itse1909.borangaziyev.model.mappers;


import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieSessionModelMapper implements RowMapper<MovieSessionModel> {


    @Override
    public MovieSessionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieSessionModel session = new MovieSessionModel();

        session.setSessionId(rs.getLong("sessionId"));
        session.setSessionDate(rs.getDate("sessionDate").toLocalDate());
        session.setStartTime(rs.getTime("startTime").toLocalTime());
        session.setEndTime(rs.getTime("endTime").toLocalTime());
        session.setPrice(rs.getInt("price"));
        session.setHallId(rs.getInt("hallId"));
        session.setMovieId(rs.getInt("movieId"));

        return session;
    }
}
