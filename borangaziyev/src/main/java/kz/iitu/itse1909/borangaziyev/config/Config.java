package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.*;
import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import kz.iitu.itse1909.borangaziyev.repository.MovieJdbcRepository;
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

//        MovieService movieService = context.getBean(MovieService.class);
//        CustomerService customerService = context.getBean(CustomerService.class);
//        BookingService bookingService = context.getBean(BookingService.class);
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


        System.out.println("____________________________________________________________________________________________");
        MovieJdbcService movieJdbcService = context.getBean(MovieJdbcService.class);
        // All Movies
        System.out.println(movieJdbcService.getAllMovies());
        // Movie by Session Id
        System.out.println(movieJdbcService.getMovieBySessionId(1));
        // Movies Sorted by Published Year
        System.out.println(movieJdbcService.getMoviesSortedByPublishedYear(2021));
        System.out.println("____________________________________________________________________________________________");
        CustomerJdbcService customerJdbcService = context.getBean(CustomerJdbcService.class);
        // All Customers
        System.out.println(customerJdbcService.getAllCustomers());
        // VIP Customers from Session
        System.out.println(customerJdbcService.getVipCustomersFromSession(1));
        System.out.println("____________________________________________________________________________________________");
        BookingJdbcService bookingJdbcService = context.getBean(BookingJdbcService.class);
        // Paid Bookings by Customer ID
        System.out.println(bookingJdbcService.getPaidBookingsByCustomerId(2));
        System.out.println("____________________________________________________________________________________________");
        // Batch Update Customers to have vip status of false
        System.out.println(customerJdbcService.batchUpdateCustomerVipStatus(false));
        // Check results
        System.out.println(customerJdbcService.getAllCustomers());
        System.out.println("____________________________________________________________________________________________");
        // Batch Update Movies to have certain published year
        System.out.println(movieJdbcService.batchUpdateMoviePublishedYear(2015));
        // Check results
        System.out.println(movieJdbcService.getAllMovies());
        System.out.println("____________________________________________________________________________________________");
        // Preparing new movies and Batch Insert new Movies
        List<MovieModel> movies = Arrays.asList(
                new MovieModel(150, 2022, "Invincible", "Invincible man is here to save the Earth!"),
                new MovieModel(125, 2020, "Parasites", "Korean movie or something"),
                new MovieModel(80, 2021, "Luka", "Great movie! But I have not seen it yet(")
        );

        System.out.println(movieJdbcService.batchInsertNewMovies(movies));
        // check results
        System.out.println(movieJdbcService.getAllMovies());





    }


}
