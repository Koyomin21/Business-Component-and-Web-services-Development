package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.service.BookingService;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Lab1Application {
    private static ApplicationContext applicationContext;


    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Lab1Application.class, args);
        MovieService movieService = applicationContext.getBean(MovieService.class);
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        BookingService bookingService = applicationContext.getBean(BookingService.class);

        System.out.println("Movies: " + movieService.getAllMovies());
        System.out.println("Customers: " + customerService.getAllCustomers());
        System.out.println("Bookings: " + bookingService.getAllBookings());
//        System.out.println("Customers: " + customerService.getAllCustomers());

        // All Customers from session
        System.out.println(customerService.getAllCustomersFromSession(1));
        // Get Bookings of a Customer that are paid
        System.out.println(bookingService.getPaidBookingsByCustomerId(1));
        // Movies sorted by published year
        System.out.println(movieService.getMoviesSortedByPublishedYear());
        // Bookings by Movie Session Id
        System.out.println(bookingService.getBookingsByMovieSessionId(2));
        // VIP Customers by Session Id
        System.out.println(customerService.getVipCustomersFromSession(1));
        // Get Movie By Session ID
        System.out.println(movieService.getMovieBySessionId(3));


    }



}
