package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import kz.iitu.itse1909.borangaziyev.repository.MovieJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieJdbcService {
    @Autowired
    private MovieJdbcRepository repo;

    public List<MovieModel> getAllMovies() {
        return repo.getAllMovies();
    }

    public MovieModel getMovieBySessionId(long sessionId) {
        // getting session
        MovieModel movie = null;
        MovieSessionModel sessionModel = repo.getMovieSessionById(sessionId);

        if(sessionModel != null && sessionModel.getMovieId() != 0) {
            movie = repo.getMovieById(sessionModel.getMovieId());
        }

        return movie;
    }
}
