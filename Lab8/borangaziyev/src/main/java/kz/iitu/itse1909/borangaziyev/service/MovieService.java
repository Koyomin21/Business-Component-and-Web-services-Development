package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.aspects.CheckArguments;
import kz.iitu.itse1909.borangaziyev.aspects.ExecutionTimeLogger;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private MovieSessionRepository sessionRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Autowired
    public void setMovieSessionRepository(MovieSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @ExecutionTimeLogger
    @Cacheable(value = "movies")
    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public List<MovieSession> getAllSessions() { return (List<MovieSession>) sessionRepository.findAll();}

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
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
        MovieSession session = sessionRepository.findById(sessionId).get();

        if(session != null && session.getMovie() != null) {
            // getting movie from session
            movie = session.getMovie();
        }

        return movie;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    @CacheEvict(value = "movies", allEntries = true)
    public void addNewMovies(List<Movie> movies) {
        movieRepository.saveAll(movies);
    }


    @CachePut(value = "movies")
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public void updateMovieSessions(List<MovieSession> sessions) {
        sessionRepository.saveAll(sessions);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public MovieSession getSessionById(long id) {
        return sessionRepository.findById(id).get();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List<Movie> getMoviesWithDescription(String description) {
        return movieRepository.findMoviesByDescriptionContaining(description);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List<MovieSession> getSessionsByPriceRange(int startPrice, int endPrice) {
        return sessionRepository.findAllByPriceBetween(startPrice, endPrice);
    }

    @Scheduled(fixedRate = 1200)
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<Movie> findMoviesWithNoDescription() {
        return movieRepository.findMoviesWithNoDescription();
    }

    public List<MovieSession> findAllSessionsByMovieTitle(String title) {
        return sessionRepository.findAllByMovieTitle(title);
    }

    public List<MovieSession> getMovieSessionsBySessionDateBetween(LocalDate startDate, LocalDate endDate) {
        return sessionRepository.getMovieSessionsBySessionDateBetween(startDate, endDate);
    }

}
