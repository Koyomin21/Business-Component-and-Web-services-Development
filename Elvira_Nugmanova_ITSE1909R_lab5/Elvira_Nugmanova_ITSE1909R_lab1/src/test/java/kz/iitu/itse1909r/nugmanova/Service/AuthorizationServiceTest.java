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

class AuthorizationServiceTest {
    @Mock
    CustomerRepositoryImpl repo;
    @InjectMocks
    AuthorizationService authorizationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCustomerByEmail() {
        when(repo.getCustomerByEmail(anyString())).thenReturn(new Customer("email", "password"));

        Customer result = authorizationService.getCustomerByEmail("email");
        Assertions.assertEquals(new Customer("email", "password"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme