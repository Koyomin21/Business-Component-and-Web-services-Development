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

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

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
        when(movieRepository.findAll()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));
        List<Movie> result = movieService.getAllMovies();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testGetMoviesSortedByPublishedYear() {
        List<Movie>allMovies = Arrays.asList(
                new Movie("titl1", 0, 2, "Description1"),
                new Movie("titl2", 5, 3, "Description2")
        );
        when(movieRepository.findAll()).thenReturn(allMovies);

        List<Movie> result = movieService.getMoviesSortedByPublishedYear();
        Assertions.assertEquals("[Movie: ID: 0 Title: titl1 Minutes: 0 Published Year: 2 Description: Description1, Movie: ID: 0 Title: titl2 Minutes: 5 Published Year: 3 Description: Description2]", result.toString());
    }

    @Test
    void testGetMovieBySessionId() {

        MovieSession session = new MovieSession();
        Movie movie = new Movie("title", 0, 0, "description");
        session.setMovie(movie);

        when(sessionRepository.findById(any())).thenReturn(java.util.Optional.of(session));

        Movie result = movieService.getMovieBySessionId(0L);
        Assertions.assertEquals(new Movie("title", 0, 0, "description"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme