package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.aspects.ExecutionTimeLogger;
import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MovieSessionRepository sessionRepository;

    public BookingService() {
        System.out.println("Booking Service was born!");
    }

    @ExecutionTimeLogger
    @Cacheable(value = "bookings")
    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @ExecutionTimeLogger
    @Cacheable(value = "bookings")
    public List<Booking> getPaidBookingsByCustomerId(long id) {
        // getting customer
        Customer customer = customerRepository.findById(id).get();
        if(customer != null && !customer.getBookings().isEmpty()) {
            // getting bookings of a customer
            List<Booking> allCustomerBookings = customer.getBookings();

            // sorting and returning bookins with isPaid = true
            return allCustomerBookings.stream()
                    .filter(b -> b.isPaid())
                    .collect(Collectors.toList());
        }
        return new ArrayList<Booking>();
    }

    @Cacheable(value = "bookings")
    public List<Booking> getBookingsByMovieSessionId(long id) {
        // getting seat first
        List<Booking> sessionBookings = new ArrayList<Booking>();
        MovieSession movieSession = sessionRepository.findById(id).get();

        if(movieSession != null && !movieSession.getBookings().isEmpty()) {
            // getting bookings from a Movie Session
            sessionBookings = movieSession.getBookings();

            return sessionBookings;
        }

        return sessionBookings;
    }

    public List<Booking> getBookingsAfterDate(LocalDate afterDate) {
        return bookingRepository.getBookingsByBookingDateAfter(afterDate);
    }

    public List<Booking> getBookingsBeforeDate(LocalDate beforeDate) {
        return bookingRepository.getBookingsByBookingDateBefore(beforeDate);
    }

    public List<Booking> getPaidBookings() {
        return bookingRepository.findPaidBookings();
    }

}
