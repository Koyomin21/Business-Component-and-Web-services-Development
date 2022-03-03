package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.Mockito.when;

@TestPropertySource("classpath.defaults.properties")
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
        when(environment.getProperty("movie.id")).thenReturn("0");
        when(environment.getProperty("movie.title")).thenReturn("title");
        when(environment.getProperty("movie.minutes")).thenReturn("1");
        when(environment.getProperty("movie.publishedYear")).thenReturn("1");
        when(environment.getProperty("movie.description")).thenReturn("description");

        Movie result = movieConfig.movie();
        System.out.println(result);
        Assertions.assertEquals("Movie: ID: 0 Title: title Minutes: 1 Published Year: 1 Description: description", result.toString());
    }

    @Test
    void testMovieSession() {
        when(environment.getProperty("movie.id")).thenReturn("0");
        when(environment.getProperty("movie.title")).thenReturn("title");
        when(environment.getProperty("movie.minutes")).thenReturn("1");
        when(environment.getProperty("movie.publishedYear")).thenReturn("1");
        when(environment.getProperty("movie.description")).thenReturn("description");
        MovieSession result = movieConfig.movieSession();

        MovieSession expected = new MovieSession();
        expected.setMovie(movieConfig.movie());

        Assertions.assertEquals(expected, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme