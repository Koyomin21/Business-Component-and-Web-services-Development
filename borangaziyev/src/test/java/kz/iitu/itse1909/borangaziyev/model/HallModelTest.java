package kz.iitu.itse1909.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HallModelTest {
    HallModel hallModel = new HallModel();

    @Test
    void testSetHallId() {
        hallModel.setHallId(0L);
    }

    @Test
    void testSetName() {
        hallModel.setName("name");
    }

    @Test
    void testSetCapacity() {
        hallModel.setCapacity(0);
    }

    @Test
    void testEquals() {
        boolean result = hallModel.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = hallModel.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = hallModel.hashCode();
        int result2 = hallModel.hashCode();
        Assertions.assertEquals(result2, result);
    }

    @Test
    void testToString() {
        String result = hallModel.toString();
        Assertions.assertEquals("HallModel(hallId=0, name=null, capacity=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme