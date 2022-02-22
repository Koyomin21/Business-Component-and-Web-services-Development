package kz.iitu.itse1909.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

class MovieSessionModelTest {
    //Field sessionDate of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field startTime of type LocalTime - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field endTime of type LocalTime - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    MovieSessionModel movieSessionModel = new MovieSessionModel();

    @Test
    void testSetSessionId() {
        movieSessionModel.setSessionId(0L);
    }

    @Test
    void testSetMovieId() {
        movieSessionModel.setMovieId(0);
    }

    @Test
    void testSetHallId() {
        movieSessionModel.setHallId(0);
    }

    @Test
    void testSetPrice() {
        movieSessionModel.setPrice(0);
    }

    @Test
    void testSetSessionDate() {
        movieSessionModel.setSessionDate(LocalDate.of(2022, Month.FEBRUARY, 22));
    }

    @Test
    void testSetStartTime() {
        movieSessionModel.setStartTime(LocalTime.of(14, 43, 9));
    }

    @Test
    void testSetEndTime() {
        movieSessionModel.setEndTime(LocalTime.of(14, 43, 9));
    }

    @Test
    void testEquals() {
        boolean result = movieSessionModel.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = movieSessionModel.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = movieSessionModel.hashCode();
        int result2 = movieSessionModel.hashCode();
        Assertions.assertEquals(result2, result);
    }

    @Test
    void testToString() {
        String result = movieSessionModel.toString();
        Assertions.assertEquals("MovieSessionModel(sessionId=0, movieId=0, hallId=0, price=0, sessionDate=null, startTime=null, endTime=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme