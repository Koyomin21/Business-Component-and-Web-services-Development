package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    MovieSessionRepository movieSessionRepository;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.<Customer>asList(new Customer()));

        List<Customer> result = customerService.getAllCustomers();
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
    }

    @Test
    void testGetAllCustomersFromSession() {
        MovieSession session = new MovieSession();
        MovieSession session2 = new MovieSession();
        session2.setBookings(Arrays.<Booking>asList());
        Booking booking = new Booking();
        booking.setCustomer(new Customer());
        session.setBookings(Arrays.<Booking>asList(booking));

        when(movieSessionRepository.findById(1l)).thenReturn(java.util.Optional.of(session));
        when(movieSessionRepository.findById(0l)).thenReturn(java.util.Optional.of(session2));

        List<Customer> result = customerService.getAllCustomersFromSession(1L);
        List<Customer> result2 = customerService.getAllCustomersFromSession(0L);


        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
        Assertions.assertNull(result2);
    }

    @Test
    void testGetVipCustomersFromSession() {
        MovieSession session = new MovieSession();
        MovieSession session2 = new MovieSession();
        Customer customer = new Customer();
        Booking booking = new Booking();


        customer.setVip(true);
        booking.setCustomer(customer);
        session2.setBookings(Arrays.<Booking>asList());
        session.setBookings(Arrays.<Booking>asList(booking));

        when(movieSessionRepository.findById(1l)).thenReturn(java.util.Optional.of(session));
        when(movieSessionRepository.findById(0l)).thenReturn(java.util.Optional.of(session2));

        List<Customer> result = customerService.getVipCustomersFromSession(1L);
        List<Customer> result2 = customerService.getVipCustomersFromSession(0L);

        Assertions.assertEquals(Arrays.<Customer>asList(customer), result);
        Assertions.assertEquals(new ArrayList<Customer>(), result2);

    }

    @Test
    void testGetCustomerByFullName() {
        when(customerRepository.getCustomerByFirstNameAndLastName(anyString(), anyString())).thenReturn(new Customer());

        Customer result = customerService.getCustomerByFullName("firstName", "lastName");
        Assertions.assertEquals(new Customer(), result);
    }

    @Test
    void testGetCustomerWithName() {
        when(customerRepository.findCustomersByLastNameContaining(anyString())).thenReturn(new Customer());

        Customer result = customerService.getCustomerWithName("name");
        Assertions.assertEquals(new Customer(), result);
    }

    @Test
    void testFindAllNotVipCustomers() throws InterruptedException {
        when(customerRepository.findAllNotVipCustomers()).thenReturn(Arrays.<Customer>asList(new Customer()));

        List<Customer> result = customerService.findAllNotVipCustomers();
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
    }

    @Test
    void testFindCustomersWithNameContaining() {
        when(customerRepository.findAllByFirstNameorLastNameContaining(anyString())).thenReturn(Arrays.<Customer>asList(new Customer()));

        List<Customer> result = customerService.findCustomersWithNameContaining("name");
        Assertions.assertEquals(Arrays.<Customer>asList(new Customer()), result);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer();
        Customer customerDetails = new Customer();
        customerDetails.setEmail("Email");
        customerDetails.setFirstName("FirstName");
        customerDetails.setLastName("LastName");
        customerDetails.setVip(true);

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(customer));
        when(customerService.updateCustomer(1l, customerDetails)).thenReturn(customer);

        Customer result = customerService.updateCustomer(1l, customerDetails);

        Assertions.assertEquals(customer, result);


    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme