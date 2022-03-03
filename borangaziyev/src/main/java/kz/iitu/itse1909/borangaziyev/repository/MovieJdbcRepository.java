package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import kz.iitu.itse1909.borangaziyev.model.mappers.MovieModelMapper;

import kz.iitu.itse1909.borangaziyev.model.mappers.MovieSessionModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public int[] batchUpdateMoviePublishedYear(int year) {
        String sql = "UPDATE Movie SET publishedYear = :year WHERE movieId = :id";

        List<MovieModel> movies = new ArrayList<>();
        List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();

        for(MovieModel c: getAllMovies()) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("year", year);
            source.addValue("id", c.getMovieId());

            params.add(source);
        }

        int []updateCounts = jdbcTemplate.batchUpdate(
                sql,
                params.toArray(MapSqlParameterSource[]::new)
        );

        return updateCounts;
    }

    public int[]batchInsertNewMovies(List<MovieModel> movies) {
        String sql = "INSERT INTO Movie(title, minutes, publishedYear, description)" +
                     "VALUES(:title, :minutes, :publishedYear, :description)";
        List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();

        for(MovieModel movie:movies) {

            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("title", movie.getTitle());
            source.addValue("minutes", movie.getMinutes());
            source.addValue("publishedYear", movie.getPublishedYear());
            source.addValue("description", movie.getDescription());

            params.add(source);
        }

        int []insertCounts = jdbcTemplate.batchUpdate(
                sql,
                params.toArray(MapSqlParameterSource[]::new)
        );

        for(int i: insertCounts) System.out.println(i);


        return insertCounts;
    }

}
