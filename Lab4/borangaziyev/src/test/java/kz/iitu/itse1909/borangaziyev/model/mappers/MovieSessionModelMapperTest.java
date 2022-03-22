package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieSessionModelMapperTest {
    MovieSessionModelMapper movieSessionModelMapper = new MovieSessionModelMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);

        when(rs.getLong("sessionId")).thenReturn(1l);
        when(rs.getDate("sessionDate")).thenReturn(new Date(20221012));
        when(rs.getTime("startTime")).thenReturn(new Time(121010));
        when(rs.getTime("endTime")).thenReturn(new Time(121010));
        when(rs.getInt("price")).thenReturn(100);
        when(rs.getInt("hallId")).thenReturn(1);
        when(rs.getInt("movieId")).thenReturn(1);


        MovieSessionModel session = new MovieSessionModel();

        session.setSessionId(rs.getLong("sessionId"));
        session.setSessionDate(rs.getDate("sessionDate").toLocalDate());
        session.setStartTime(rs.getTime("startTime").toLocalTime());
        session.setEndTime(rs.getTime("endTime").toLocalTime());
        session.setPrice(rs.getInt("price"));
        session.setHallId(rs.getInt("hallId"));
        session.setMovieId(rs.getInt("movieId"));

        MovieSessionModel result = movieSessionModelMapper.mapRow(rs, 0);
        Assertions.assertEquals(session, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme