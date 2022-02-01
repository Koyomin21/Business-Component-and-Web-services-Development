package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepository;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public BookingService() {
        System.out.println("Booking Service was born!");
    }

    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    public List<Booking> getPaidBookingsByCustomerId(long id) {
        // getting customer
        Customer customer = customerRepository.findById(id).get();
        if(customer != null || !customer.getBookings().isEmpty()) {
            List<Booking> allCustomerBookings = customer.getBookings();

            return allCustomerBookings.stream()
                    .filter(b -> b.isPaid())
                    .collect(Collectors.toList());
        }
        return null;
    }


}
