package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.model.BookingModel;
import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import kz.iitu.itse1909.borangaziyev.repository.BookingJdbcRepository;
import kz.iitu.itse1909.borangaziyev.repository.CustomerJdbcRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerJdbcService {
    @Autowired
    private CustomerJdbcRepository customerRepo;

    @Autowired
    private MovieJdbcRepository movieRepo;

    @Autowired
    private BookingJdbcRepository bookingRepo;

    public List<CustomerModel> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    public List<CustomerModel> getVipCustomersFromSession(long id) {
        // getting the Movie Session by Id
        MovieSessionModel sessionModel = movieRepo.getMovieSessionById(id);

        if(sessionModel != null) {
            // getting all bookings of the given movie session
            List<BookingModel> bookings = bookingRepo.getBookingsBySessionId(sessionModel.getSessionId());

            // getting the ids of customers who have these bookings
            List<Integer>customerIds = bookings.stream().map(b -> b.getCustomerId()).collect(Collectors.toList());

            // getting customers by their id and filtering VIP
            return customerIds.stream()
                    .map(c -> customerRepo.getCustomerById(c))
                    .filter(c -> c.isVip())
                    .collect(Collectors.toList());
        }

        return new ArrayList<CustomerModel>();
    }

    public int[] batchUpdateCustomerVipStatus(boolean vipStatus) {
        return customerRepo.batchUpdateVipStatus(vipStatus);
    }
}
