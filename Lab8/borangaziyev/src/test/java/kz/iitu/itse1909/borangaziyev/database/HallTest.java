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

class HallTest {
    @Mock
    List<MovieSession> sessions;
    @Mock
    List<Seat> seats;
    @InjectMocks
    Hall hall;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetHallId() {
        hall.setHallId(0L);
    }

    @Test
    void testSetName() {
        hall.setName("name");
    }

    @Test
    void testSetCapacity() {
        hall.setCapacity(0);
    }

    @Test
    void testSetSessions() {
        hall.setSessions(Arrays.<MovieSession>asList(new MovieSession(new Hall(), 0, LocalDate.of(2022, Month.FEBRUARY, 8), LocalTime.of(13, 59, 47), LocalTime.of(13, 59, 47))));
    }

    @Test
    void testSetSeats() {
        hall.setSeats(Arrays.<Seat>asList(new Seat()));
    }

    @Test
    void testEquals() {
        boolean result = hall.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = hall.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = hall.hashCode();
        Hall hall2 = hall;
        Assertions.assertEquals(hall2.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = hall.toString();
        Assertions.assertEquals("Hall(hallId=0, name=null, capacity=0, sessions=sessions, seats=seats)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme