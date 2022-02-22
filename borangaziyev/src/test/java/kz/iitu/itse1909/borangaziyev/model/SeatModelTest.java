package kz.iitu.itse1909.borangaziyev.model;

import kz.iitu.itse1909.borangaziyev.database.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SeatModelTest {
    SeatModel seatModel = new SeatModel();

    @Test
    void testSetSeatId() {
        seatModel.setSeatId(0L);
    }

    @Test
    void testSetRow() {
        seatModel.setRow(0);
    }

    @Test
    void testSetNumber() {
        seatModel.setNumber(0);
    }

    @Test
    void testSetHallId() {
        seatModel.setHallId(0);
    }

    @Test
    void testEquals() {
        boolean result = seatModel.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = seatModel.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = seatModel.hashCode();
        SeatModel s = seatModel;
        Assertions.assertEquals(s.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = seatModel.toString();
        Assertions.assertEquals("SeatModel(seatId=0, row=0, number=0, hallId=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme