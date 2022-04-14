package kz.iitu.itse1909.borangaziyev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class MovieControllerTest {
    @Mock
    MovieService movieService;
    @Mock
    ObjectMapper om;
    @InjectMocks
    MovieController movieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllMovies() {
        when(movieService.getAllMovies()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));

        List<Movie> result = movieController.getAllMovies();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testGetMoviesSortedByPublishedYear() {
        when(movieService.getMoviesSortedByPublishedYear()).thenReturn(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")));

        List<Movie> result = movieController.getMoviesSortedByPublishedYear();
        Assertions.assertEquals(Arrays.<Movie>asList(new Movie("title", 0, 0, "description")), result);
    }

    @Test
    void testAddNewMovies() {
        String result = movieController.addNewMovies("moviesListJson");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testDeleteMovie() {
        String result = movieController.deleteMovie(0L);
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme