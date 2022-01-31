package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;

import kz.iitu.itse1909.borangaziyev.repository.MovieRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private MovieSessionRepository sessionRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, MovieSessionRepository sessionRepository) {
        this.customerRepository = customerRepository;
        this.sessionRepository = sessionRepository;
    }


    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public List<Customer> getAllCustomersFromSession(long sessionId) {
        // get session
        MovieSession session = sessionRepository.findById(sessionId).get();

        if(session != null || !session.getBookings().isEmpty()) {
            List<Booking> sessionBookings = session.getBookings();
            System.out.println("Session Bookings: ");
            System.out.println(sessionBookings.size());
            List<Customer> customers = sessionBookings.stream().map(s -> s.getCustomer()).collect(Collectors.toList());

            return customers;
        }

        return null;
    }



}
