package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepo;
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
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

class MovieServiceTest {
    @Mock
    MovieRepo movieRepository;
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
        when(movieRepository.findAll()).thenReturn(Arrays.<Movie>asList(new Movie(null, 0, 0, null)));

        List<Movie> result = movieService.getMoviesSortedByPublishedYear();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie(null, 0, 0, null)), result);
    }

    @Test
    void testGetMovieBySessionId() {
        when(movieRepository.getSessionById(anyLong())).thenReturn(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 5), LocalTime.of(8, 49, 24), LocalTime.of(8, 49, 24)));

        Movie result = movieService.getMovieBySessionId(0L);
        Assertions.assertEquals(new Movie("title", 0, 0, "description"), result);
    }

    @Test
    void testAddNewMovies() {
        movieService.addNewMovies(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));
    }

    @Test
    void testUpdateMovieSessionDates() {
        movieService.updateMovieSessionDates(new HashMap<MovieSession, LocalDate>() {{
            put(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 5), LocalTime.of(8, 49, 24), LocalTime.of(8, 49, 24)), LocalDate.of(2022, Month.MARCH, 5));
        }});
    }

    @Test
    void testGetSessionById() {
        when(movieRepository.getSessionById(anyLong())).thenReturn(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 5), LocalTime.of(8, 49, 24), LocalTime.of(8, 49, 24)));

        MovieSession result = movieService.getSessionById(0L);
        Assertions.assertEquals(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.MARCH, 5), LocalTime.of(8, 49, 24), LocalTime.of(8, 49, 24)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme