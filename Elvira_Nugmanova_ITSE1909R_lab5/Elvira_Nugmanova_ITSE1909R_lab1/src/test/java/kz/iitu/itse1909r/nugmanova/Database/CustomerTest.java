package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {
    Customer customer = new Customer("email", "password");
    Customer cst = new Customer();


    @Test
    void testToString() {
        String result = customer.toString();
        Assertions.assertEquals("CUSTOMER DATA: email password", result);
    }

    @Test
    void testSetCustomerId() {
        customer.setCustomerId(Integer.valueOf(0));
    }

    @Test
    void testSetEmail() {
        customer.setEmail("email");
        cst.setEmail("aaa");
    }

    @Test
    void testSetPassword() {
        customer.setPassword("password");
    }

    @Test
    void testEquals() {
        boolean result = customer.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = customer.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = customer.hashCode();
        Assertions.assertEquals(customer.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme