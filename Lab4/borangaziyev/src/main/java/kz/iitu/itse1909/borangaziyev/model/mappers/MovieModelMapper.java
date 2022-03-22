package kz.iitu.itse1909.borangaziyev.model.mappers;


import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieModelMapper implements RowMapper<MovieModel> {

    @Override
    public MovieModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieModel movie = new MovieModel();
        movie.setMovieId(rs.getLong("movieId"));
        movie.setTitle(rs.getString("title"));
        movie.setDescription(rs.getString("description"));
        movie.setMinutes(rs.getInt("minutes"));
        movie.setPublishedYear(rs.getInt("publishedYear"));

        return movie;

    }
}
