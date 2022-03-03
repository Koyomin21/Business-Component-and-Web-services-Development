package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

class OrderTest {
    @Mock
    Cart cart;
    //Field orderDate of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetOrderId() {
        order.setOrderId(Integer.valueOf(0));
    }

    @Test
    void testSetCart() {
        order.setCart(new Cart());
    }

    @Test
    void testSetVersion() {
        order.setVersion(0);
    }

    @Test
    void testSetOrderDate() {
        order.setOrderDate(LocalDate.of(2022, Month.MARCH, 2));
    }

    @Test
    void testEquals() {
        boolean result = order.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = order.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = order.hashCode();
        Assertions.assertEquals(order.hashCode(), result);
    }

    @Test
    void testToString() {
        String result = order.toString();
        Assertions.assertEquals("Order(orderId=null, cart=cart, version=0, orderDate=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme