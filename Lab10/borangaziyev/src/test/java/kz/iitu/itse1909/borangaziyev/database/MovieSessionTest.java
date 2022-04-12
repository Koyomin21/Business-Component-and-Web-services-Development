package kz.iitu.itse1909.borangaziyev.database;

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

import static org.mockito.Mockito.when;

class MovieSessionTest {
    @Mock
    Movie movie;
    @Mock
    Hall hall;
    //Field sessionDate of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field startTime of type LocalTime - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field endTime of type LocalTime - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    List<Booking> bookings;
    @InjectMocks
    MovieSession movieSession;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testToString() {
        when(movie.getTitle()).thenReturn("getTitleResponse");

        String result = movieSession.toString();
        Assertions.assertEquals("Session: Movie: getTitleResponse Session date: null Time: null - null", result);
    }

    @Test
    void testSetSessionId() {
        movieSession.setSessionId(0L);
    }

    @Test
    void testSetMovie() {
        movieSession.setMovie(new Movie("title", 0, 0, "description"));
    }

    @Test
    void testSetHall() {
        movieSession.setHall(new Hall());
    }

    @Test
    void testSetPrice() {
        movieSession.setPrice(0);
    }

    @Test
    void testSetSessionDate() {
        movieSession.setSessionDate(LocalDate.of(2022, Month.FEBRUARY, 8));
    }

    @Test
    void testSetStartTime() {
        movieSession.setStartTime(LocalTime.of(14, 1, 51));
    }

    @Test
    void testSetEndTime() {
        movieSession.setEndTime(LocalTime.of(14, 1, 51));
    }

    @Test
    void testSetBookings() {
        movieSession.setBookings(Arrays.<Booking>asList(new Booking()));
    }

    @Test
    void testEquals() {
        boolean result = movieSession.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = movieSession.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = movieSession.hashCode();
        MovieSession session = movieSession;
        Assertions.assertEquals(session.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme