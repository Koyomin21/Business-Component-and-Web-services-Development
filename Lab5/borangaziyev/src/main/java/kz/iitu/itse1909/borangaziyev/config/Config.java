package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.*;
import kz.iitu.itse1909.borangaziyev.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

@Configuration
@Import({MovieConfig.class, CustomerConfig.class})
public class Config {

    @Bean
    @DependsOn("hall")
    public Seat seat() {
        return new Seat();
    }

    @Bean
    public Hall hall() {
        return new Hall();
    }


    public void runServiceMethods(ApplicationContext context) {

        MovieService movieService = context.getBean(MovieService.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        BookingService bookingService = context.getBean(BookingService.class);
//
//        Seat seat = context.getBean(Seat.class);
//        Movie movie = context.getBean(Movie.class);
//        System.out.println("Default Movie: " + movie);
//        Customer customer = context.getBean(Customer.class);
//        System.out.println("Default Customer: " + customer);
//
//        MovieSession session = context.getBean(MovieSession.class);
//        System.out.println("Default Movie Session: " + session);
//
//        System.out.println("Movies: " + movieService.getAllMovies());
//        System.out.println("Customers: " + customerService.getAllCustomers());
//        System.out.println("Bookings: " + bookingService.getAllBookings());
//        // All Customers from session
//        System.out.println(customerService.getAllCustomersFromSession(1));
//        // Get Bookings of a Customer that are paid
//        System.out.println(bookingService.getPaidBookingsByCustomerId(1));
//        // Movies sorted by published year
//        System.out.println(movieService.getMoviesSortedByPublishedYear());
//        // Bookings by Movie Session Id
//        System.out.println(bookingService.getBookingsByMovieSessionId(2));
//        // VIP Customers by Session Id
//        System.out.println(customerService.getVipCustomersFromSession(1));
//        // Get Movie By Session ID
//        System.out.println(movieService.getMovieBySessionId(3));
        System.out.println(bookingService.getAllBookings());
        System.out.println(bookingService.getPaidBookingsByCustomerId(1));

    }


}
