package kz.iitu.itse1909.borangaziyev.service;

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

import java.util.Arrays;
import java.util.List;

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
    void testGetMoviesSortedByPublishedYear() {
        List<Movie> moviesByPublishedYears = Arrays.asList(
                new Movie(null, 0, 1995, null),
                new Movie(null, 0, 1998, null),
                new Movie(null, 0, 2001, null)
        );
        when(movieService.getMoviesSortedByPublishedYear()).thenReturn(moviesByPublishedYears);
        List<Movie> result = movieService.getMoviesSortedByPublishedYear();
        Assertions.assertEquals(
                Arrays.<Movie>asList(
                        new Movie(null, 0, 1995, null),
                        new Movie(null, 0, 1998, null),
                        new Movie(null, 0, 2001, null)
                ), result);
    }

    @Test
    void testGetMovieBySessionId() {
        when(sessionRepository.findById(any())).thenReturn(java.util.Optional.of(new MovieSession()));
        when(movieService.getMovieBySessionId(any())).thenReturn(new Movie());
        Movie result = movieService.getMovieBySessionId(0L);

        Assertions.assertTrue(result != null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme