package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.model.BookingModel;
import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.repository.BookingJdbcRepository;
import kz.iitu.itse1909.borangaziyev.repository.CustomerJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingJdbcService {

    @Autowired
    private BookingJdbcRepository bookingRepo;

    @Autowired
    private CustomerJdbcRepository customerRepo;

    public List<BookingModel> getBookingsBySessionId(long id) {
        return bookingRepo.getBookingsBySessionId(id);
    }

    public List<BookingModel> getPaidBookingsByCustomerId(long custId) {
        // getting the customer by Id
        CustomerModel customer = customerRepo.getCustomerById(custId);
        if(customer != null) {
            // if not null, get all bookings of this customer
            List<BookingModel> bookings = bookingRepo.getBookingsByCustomerId(customer.getCustomerId());

            // filtering bookings by 'isPaid' field
            return bookings.stream()
                    .filter(b -> b.isPaid())
                    .collect(Collectors.toList());
        }

        return new ArrayList<BookingModel>();
    }
}
