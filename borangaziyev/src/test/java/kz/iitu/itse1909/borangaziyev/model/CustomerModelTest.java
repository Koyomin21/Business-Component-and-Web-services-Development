package kz.iitu.itse1909.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerModelTest {
    CustomerModel customerModel = new CustomerModel();

    @Test
    void testSetCustomerId() {
        customerModel.setCustomerId(0L);
    }

    @Test
    void testSetFirstName() {
        customerModel.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        customerModel.setLastName("lastName");
    }

    @Test
    void testSetEmail() {
        customerModel.setEmail("email");
    }

    @Test
    void testSetVip() {
        customerModel.setVip(true);
    }

    @Test
    void testEquals() {
        boolean result = customerModel.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = customerModel.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = customerModel.hashCode();
        int result2 = customerModel.hashCode();
        Assertions.assertEquals(result2, result);
    }

    @Test
    void testToString() {
        String result = customerModel.toString();
        Assertions.assertEquals("CustomerModel(customerId=0, firstName=null, lastName=null, email=null, isVip=false)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme