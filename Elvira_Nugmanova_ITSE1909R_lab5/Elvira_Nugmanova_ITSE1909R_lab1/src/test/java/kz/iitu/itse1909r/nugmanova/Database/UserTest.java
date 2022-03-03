package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    User user = new User();

    @Test
    void testSetUserId() {
        user.setUserId(0);
    }

    @Test
    void testSetName() {
        user.setName("name");
    }

    @Test
    void testSetSurname() {
        user.setSurname("surname");
    }

    @Test
    void testEquals() {
        boolean result = user.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = user.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = user.hashCode();
        Assertions.assertEquals(user.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = user.toString();
        Assertions.assertEquals("User(userId=0, name=null, surname=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme