package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class MovieServiceTest {
    @Mock
    MovieRepository movieRepository;
    @Mock
    MovieSessionRepository sessionRepository;
    @InjectMocks
    MovieService movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllMovies() {
        when(movieService.getAllMovies()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));


        List<Movie> result = movieService.getAllMovies();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testGetAllSessions() {
        when(movieService.getAllSessions()).thenReturn(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))));

        List<MovieSession> result = movieService.getAllSessions();

        Assertions.assertEquals(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))), result);
    }

    @Test
    void testGetMoviesSortedByPublishedYear() {
        when(movieService.getAllMovies()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));


        List<Movie> result = movieService.getMoviesSortedByPublishedYear();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testGetMovieBySessionId() {
        MovieSession session = new MovieSession();
        MovieSession session2 = new MovieSession();
        Movie movie = new Movie("title", 0, 0, "description");

        session.setMovie(movie);

        when(sessionRepository.findById(1l)).thenReturn(Optional.of(session));
        when(sessionRepository.findById(0l)).thenReturn(Optional.of(session2));


        Movie result = movieService.getMovieBySessionId(1L);
        Movie result2 = movieService.getMovieBySessionId(0L);


        Assertions.assertEquals(new Movie("title", 0, 0, "description"), result);
        Assertions.assertNull(result2);
    }

    @Test
    void testAddNewMovies() {
        movieService.addNewMovies(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));
    }

    @Test
    void testUpdateMovieSessions() {
        movieService.updateMovieSessions(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))));
    }

    @Test
    void testGetSessionById() {
        MovieSession session = new MovieSession();

        when(sessionRepository.findById(anyLong())).thenReturn(Optional.of(session));


        MovieSession result = movieService.getSessionById(0L);
        Assertions.assertEquals(new MovieSession(), result);
    }

    @Test
    void testGetMoviesWithDescription() {
        when(movieRepository.findMoviesByDescriptionContaining(anyString())).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));

        List<Movie> result = movieService.getMoviesWithDescription("description");
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testGetSessionsByPriceRange() {
        when(sessionRepository.findAllByPriceBetween(anyInt(), anyInt())).thenReturn(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))));

        List<MovieSession> result = movieService.getSessionsByPriceRange(0, 0);
        Assertions.assertEquals(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))), result);
    }

    @Test
    void testFindMoviesWithNoDescription() {
        when(movieRepository.findMoviesWithNoDescription()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));

        List<Movie> result = movieService.findMoviesWithNoDescription();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testFindAllSessionsByMovieTitle() {
        when(sessionRepository.findAllByMovieTitle(anyString())).thenReturn(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))));

        List<MovieSession> result = movieService.findAllSessionsByMovieTitle("title");
        Assertions.assertEquals(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))), result);
    }

    @Test
    void testGetMovieSessionsBySessionDateBetween() {
        when(sessionRepository.getMovieSessionsBySessionDateBetween(any(), any())).thenReturn(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))));

        List<MovieSession> result = movieService.getMovieSessionsBySessionDateBetween(LocalDate.of(2022, Month.MARCH, 6), LocalDate.of(2022, Month.MARCH, 6));
        Assertions.assertEquals(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 6), LocalTime.of(12, 9, 12), LocalTime.of(12, 9, 12))), result);
    }

    @Test
    void testSetMovieSessionRepository() {
        MovieSessionRepository sessionRepo = sessionRepository;
        movieService.setMovieSessionRepository(sessionRepo);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme