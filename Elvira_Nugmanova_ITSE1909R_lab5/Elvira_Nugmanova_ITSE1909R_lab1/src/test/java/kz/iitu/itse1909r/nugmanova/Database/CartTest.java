package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CartTest {
    Cart cart = new Cart();

    @Test
    void testSetCartId() {
        cart.setCartId(Integer.valueOf(0));
    }


    @Test
    void testEquals() {
        boolean result = cart.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = cart.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = cart.hashCode();
        Assertions.assertEquals(cart.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = cart.toString();
        Assertions.assertEquals("Cart(cartId=null, books=null, customer=null, order=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme