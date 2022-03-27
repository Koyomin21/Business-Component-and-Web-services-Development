package kz.iitu.itse1909.borangaziyev.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.constraints.AssertFalse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieTest {
    @Mock
    List<MovieSession> sessions;
    @InjectMocks
    Movie movie;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMovieInit() {
        movie.movieInit();
    }

    @Test
    void testMovieDestroy() {
        movie.movieDestroy();
    }

    @Test
    void testToString() {
        String result = movie.toString();
        Assertions.assertEquals("Movie: ID: 0 Title: null Minutes: 0 Published Year: 0 Description: null", result);
    }

    @Test
    void testSetMovieId() {
        movie.setMovieId(0L);
    }

    @Test
    void testSetMinutes() {
        movie.setMinutes(0);
    }

    @Test
    void testSetPublishedYear() {
        movie.setPublishedYear(0);
    }

    @Test
    void testSetTitle() {
        movie.setTitle("title");
    }

    @Test
    void testSetDescription() {
        movie.setDescription("description");
    }

    @Test
    void testSetSessions() {
        movie.setSessions(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.FEBRUARY, 8), LocalTime.of(14, 0, 41), LocalTime.of(14, 0, 41))));
    }

    @Test
    void testEquals() {
        boolean result = movie.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = movie.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = movie.hashCode();
        Movie movie2 = movie;
        Assertions.assertEquals(movie2.hashCode(), result);
    }

    @Test
    void isMovieWithDescription() {
        Movie movie = mock(Movie.class);
        movie.setDescription("");

        when(movie.isMovieWithDescription()).thenReturn(false);
        Boolean result = movie.isMovieWithDescription();

        movie.setDescription("asas");
        when(movie.isMovieWithDescription()).thenReturn(true);


        Boolean result2 = movie.isMovieWithDescription();

        Assertions.assertFalse(result);
        Assertions.assertTrue(result2);

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme