package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.*;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepository;
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
import java.util.stream.Collectors;

@Configuration
@Import({MovieConfig.class, CustomerConfig.class, CacheConfig.class})
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

        System.out.println("__________________________________________________________________________");

        System.out.println("Movies: " + movieService.getAllMovies());
        System.out.println("Customers: " + customerService.getAllCustomers());
        System.out.println("Bookings: " + bookingService.getAllBookings());
//        System.out.println("__________________________________________________________________________");
//        System.out.println("Movies: " + movieService.getAllMovies());
//        System.out.println("Customers: " + customerService.getAllCustomers());
//        System.out.println("Bookings: " + bookingService.getAllBookings());
//        System.out.println("__________________________________________________________________________");
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
        // Batch insert new Movies
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
        // Update Movie Sessions
        movieService.updateMovieSessions(movieService.getAllSessions().stream()
                .map(s -> {
                    if(s.getSessionDate().getYear() < 2015)
                        s.setSessionDate(LocalDate.of(2021, 4, 12));
                    return s;
                })
                .collect(Collectors.toList())
        );
        System.out.println(movieService.getAllSessions());
        // NamedQueries
        // Booking
        System.out.println(bookingService.getPaidBookings());
        // Customer
        System.out.println(customerService.findAllNotVipCustomers());
        // Movie
        System.out.println(movieService.findMoviesWithNoDescription());
        // MovieSession
        System.out.println(movieService.findAllSessionsByMovieTitle("Edge of Tomorrow"));
//        System.out.println(movieService.getSessionById(5)+ "\n" + movieService.getSessionById(2));

        // @Query
        System.out.println(customerService.findCustomersWithNameContaining("ya"));
        System.out.println(movieService.getMovieSessionsBySessionDateBetween(
                LocalDate.of(2020, 3, 10),
                LocalDate.of(2021, 4, 13)
                )
        );

    }


}
