package kz.iitu.itse1909.borangaziyev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CustomerControllerTest {
    @Mock
    CustomerService customerService;
    @Mock
    ObjectMapper objectMapper;
    @InjectMocks
    CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(Arrays.<Customer>asList(new Customer()));

        List<Customer> result = customerController.getAllCustomers();
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);

        when(customerService.getAllCustomers()).thenThrow(ResponseStatusException.class);

        Assertions.assertThrows(Exception.class, ()->{
            customerService.getAllCustomers();
        });

    }

    @Test
    void testUpdateCustomer() {
        when(customerService.updateCustomer(anyLong(), any())).thenReturn(new Customer());

        ResponseEntity<Customer> result = customerController.updateCustomer(0L, new Customer());
        Assertions.assertEquals("<200 OK OK,Customer: ID: 0 Email: null First Name: null Last Name: null Is Vip: false,[]>", result.toString());
    }

    @Test
    void testCheckCustomerExistence() {
        when(customerService.getAllCustomers()).thenReturn(Arrays.<Customer>asList(new Customer()));
        ResponseEntity<Customer> result = customerController.checkCustomerExistence(0L);
        Assertions.assertNotNull(result);

        when(customerService.getAllCustomers()).thenThrow(ResponseStatusException.class);

        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class, () -> {
            customerService.getAllCustomers();
        });
        System.out.println(thrown.getMessage());
        Assertions.assertTrue(thrown.getMessage().equals("0"));
    }

    @Test
    void testOptions() {
        HttpServletResponse response = mock(HttpServletResponse.class);
        ResponseEntity result = customerController.options(response);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme