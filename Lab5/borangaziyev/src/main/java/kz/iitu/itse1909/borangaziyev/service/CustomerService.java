package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.aspects.ExecutionTimeLogger;
import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepo;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private MovieRepo movieRepo;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, MovieRepo movieRepo) {
        this.customerRepository = customerRepository;
        this.movieRepo = movieRepo;
    }

    @ExecutionTimeLogger
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public List<Customer> getAllCustomersFromSession(long sessionId) {
        // get session
        MovieSession session = movieRepo.getSessionById(sessionId);

        if(session != null && !session.getBookings().isEmpty()) {
            List<Booking> sessionBookings = session.getBookings();
            List<Customer> customers = sessionBookings.stream().map(s -> s.getCustomer()).collect(Collectors.toList());

            return customers;
        }

        return null;
    }

    public List<Customer> getVipCustomersFromSession(long sessionId) {
        // get session
        MovieSession session = movieRepo.getSessionById(sessionId);

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

}
