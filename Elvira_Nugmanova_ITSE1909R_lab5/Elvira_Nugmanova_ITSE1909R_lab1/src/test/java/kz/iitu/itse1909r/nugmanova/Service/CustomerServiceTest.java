package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Customer;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.CustomerRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CustomerServiceTest {
    @Mock
    CustomerRepositoryImpl customerRepository;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSignInCustomer() {
        customerService.signInCustomer("email", "password");
    }

    @Test
    void testLoginCustomer() {
        when(customerRepository.getCustomerByEmailAndPassword("email", "password")).thenReturn(new Customer("email", "password"));
        String result = customerService.loginCustomer("email", "password");
        String result2 = customerService.loginCustomer("email2", "password2");

        Assertions.assertEquals("CUSTOMER DATA: email password", result);
        Assertions.assertEquals("Sorry, there is no such user as email2 with password password2", result2);
    }

    @Test
    void testDeleteCustomer() {
        when(customerRepository.getCustomerByEmailAndPassword("email", "password")).thenReturn(new Customer("email", "password"));

        String result = customerService.deleteCustomer("email", "password");
        String result2 = customerService.deleteCustomer("emailWrong", "passwordWrong");


        Assertions.assertEquals("The customer has been deleted!", result);
        Assertions.assertEquals("Sorry, there is no such user as emailWrong with password passwordWrong", result2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme