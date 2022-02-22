package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import kz.iitu.itse1909.borangaziyev.model.mappers.MovieModelMapper;

import kz.iitu.itse1909.borangaziyev.model.mappers.MovieSessionModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MovieJdbcRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<MovieModel> getAllMovies() {
        String sql = "SELECT * FROM Movie";

        return jdbcTemplate.query(sql, new MovieModelMapper());
    }

    public MovieSessionModel getMovieSessionById(long id) {
        MovieSessionModel sessionModel = jdbcTemplate.queryForObject(
                "SELECT * FROM MovieSession WHERE sessionId = :id",
                new MapSqlParameterSource().addValue("id", id),
                new MovieSessionModelMapper()
        );
        return sessionModel;
    }


    public MovieModel getMovieById(long id) {
        String sql = "SELECT * FROM Movie WHERE movieId = :movieId";
        MovieModel movieModel = jdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource().addValue("movieId", id),
                new MovieModelMapper()
        );
        return movieModel;
    }



}
