package kz.iitu.itse1909.borangaziyev.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

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
        hall.setSessions(Arrays.<MovieSession>asList(new MovieSession()));
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
        Hall hallRes = hall;
        int result = hall.hashCode();
        Assertions.assertEquals(hallRes.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = hall.toString();
        Assertions.assertEquals("Hall(hallId=0, name=null, capacity=0, sessions=sessions, seats=seats)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme