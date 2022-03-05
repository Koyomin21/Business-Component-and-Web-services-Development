package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.aspects.CheckArguments;
import kz.iitu.itse1909.borangaziyev.aspects.ExecutionTimeLogger;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepo;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepo movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepo movieRepository) {
        this.movieRepository = movieRepository;
    }
//    @Autowired
//    public void setMovieSessionRepository(MovieSessionRepository sessionRepository) {
//        this.sessionRepository = sessionRepository;
//    }

    @ExecutionTimeLogger
    @Cacheable(value = "movies")
    public List<Movie> getAllMovies() {
        return (List<Movie>)movieRepository.findAll();
    }

    @Cacheable(value = "movies")
    public List<Movie> getMoviesSortedByPublishedYear() {
        // getting movies from repository
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        // sorting movies by published year
        List<Movie> sortedMovies = movies.stream()
                .sorted(Comparator.comparingInt(Movie::getPublishedYear))
                .collect(Collectors.toList());

        return sortedMovies;
    }

    @CheckArguments
    public Movie getMovieBySessionId(long sessionId) {
        // getting session
        Movie movie = null;
        MovieSession session = movieRepository.getSessionById(sessionId);

        if(session != null && session.getMovie() != null) {
            // getting movie from session
            movie = session.getMovie();
        }

        return movie;
    }

    @CacheEvict(value = "movies", allEntries = true)
    public void addNewMovies(List<Movie> movies) {
        movieRepository.batchInsertNewMovies(movies);
    }


    @CachePut(value = "movies")
    public void updateMovieSessionDates(Map<MovieSession, LocalDate> sessionLocalDateMap) {
        movieRepository.batchUpdateMovieSessionsDate(sessionLocalDateMap);
    }

    public MovieSession getSessionById(long id) {
        return movieRepository.getSessionById(id);
    }



}
