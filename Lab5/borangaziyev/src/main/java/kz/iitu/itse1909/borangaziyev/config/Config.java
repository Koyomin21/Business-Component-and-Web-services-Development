package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.*;
import kz.iitu.itse1909.borangaziyev.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        System.out.println("Movies: " + movieService.getAllMovies());
        System.out.println("Customers: " + customerService.getAllCustomers());
        System.out.println("Bookings: " + bookingService.getAllBookings());
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

        List<Movie> movies = Arrays.asList(
                new Movie("Title1", 1, 1923, "Description1"),
                new Movie("Title2", 2, 1823, "Description2"),
                new Movie("Title3", 3, 1943, "Description3"),
                new Movie("Title4", 4, 1976, "Description4"),
                new Movie("Title5", 5, 1982, "Description5"),
                new Movie("Title6", 6, 1965, "Description6")
        );

        movieService.addNewMovies(movies);
        System.out.println(movieService.getAllMovies());

        Map<MovieSession, LocalDate> map = new HashMap<>();
        map.put(movieService.getSessionById(5), LocalDate.of(2021, 12, 12));
        map.put(movieService.getSessionById(2), LocalDate.of(2022, 5, 2));

        movieService.updateMovieSessionDates(map);

        System.out.println(movieService.getSessionById(5)+ "\n" + movieService.getSessionById(2));


    }


}
