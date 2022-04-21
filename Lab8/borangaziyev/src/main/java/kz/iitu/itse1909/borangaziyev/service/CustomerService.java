package kz.iitu.itse1909.borangaziyev.service;


import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private MovieSessionRepository movieSessionRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, MovieSessionRepository movieRepo) {
        this.customerRepository = customerRepository;
        this.movieSessionRepository = movieRepo;
    }

    @Cacheable("customers")
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public List<Customer> getAllCustomersFromSession(long sessionId) {
        // get session
        MovieSession session = movieSessionRepository.findById(sessionId).get();

        if(session != null && !session.getBookings().isEmpty()) {
            List<Booking> sessionBookings = session.getBookings();
            List<Customer> customers = sessionBookings.stream()
                    .map(s -> s.getCustomer())
                    .collect(Collectors.toList());

            return customers;
        }

        return null;
    }

    public List<Customer> getVipCustomersFromSession(long sessionId) {
        // get session
        MovieSession session = movieSessionRepository.findById(sessionId).get();

        if(session != null && !session.getBookings().isEmpty()) {
            // getting bookings
            List<Booking> sessionBookings = session.getBookings();
            // getting customers from bookings
            List<Customer> customers = sessionBookings.stream().map(s -> s.getCustomer()).collect(Collectors.toList());
            // returning filtered customer list with isVIP = true
            return customers.stream()
                    .filter(c -> c.isVip() == true)
                    .collect(Collectors.toList());
        }
        return new ArrayList<Customer>();
    }

    public Customer getCustomerByFullName(String firstName, String lastName) {
        return customerRepository.getCustomerByFirstNameAndLastName(firstName, lastName);
    }

    public Customer getCustomerWithName(String name) {
        return customerRepository.findCustomersByLastNameContaining(name);
    }


    public List<Customer> findAllNotVipCustomers() {
        return customerRepository.findAllNotVipCustomers();
    }

    @Transactional(readOnly = true)
    public List<Customer> findCustomersWithNameContaining(String name) {
        return customerRepository.findAllByFirstNameorLastNameContaining(name);
    }

    @Transactional
    @CacheEvict(value = "customers", allEntries = true)
    public Customer updateCustomer(long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id:" + id));
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setEmail(customerDetails.getEmail());
        customer.setVip(customerDetails.isVip());
        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }


}
