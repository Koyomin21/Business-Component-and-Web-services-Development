package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieModelMapperTest {
    MovieModelMapper movieModelMapper = new MovieModelMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);

        when(rs.getLong("movieId")).thenReturn(1l);
        when(rs.getString("title")).thenReturn("title");
        when(rs.getString("description")).thenReturn("Description");
        when(rs.getInt("minutes")).thenReturn(0);
        when(rs.getInt("publishedYear")).thenReturn(0);

        MovieModel movie = new MovieModel();
        movie.setMovieId(rs.getLong("movieId"));
        movie.setTitle(rs.getString("title"));
        movie.setDescription(rs.getString("description"));
        movie.setMinutes(rs.getInt("minutes"));
        movie.setPublishedYear(rs.getInt("publishedYear"));

        MovieModel result = movieModelMapper.mapRow(rs, 0);
        Assertions.assertEquals(movie, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme