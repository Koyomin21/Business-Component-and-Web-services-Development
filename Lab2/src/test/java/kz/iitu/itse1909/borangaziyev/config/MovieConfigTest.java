package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.mockito.Mockito.*;

class MovieConfigTest {
    @Mock
    Environment environment;
    @InjectMocks
    MovieConfig movieConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMovie() {

        when(environment.getProperty("movie.Id")).thenReturn("0");
        Movie result = movieConfig.movie();
        System.out.println(result);
        Assertions.assertEquals(new Movie("title", 0, 0, "description"), result);
    }

    @Test
    void testMovieSession() {
        MovieSession result = movieConfig.movieSession();
        Assertions.assertEquals(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.FEBRUARY, 7), LocalTime.of(21, 5, 51), LocalTime.of(21, 5, 51)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme