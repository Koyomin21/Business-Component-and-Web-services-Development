package kz.iitu.itse1909.borangaziyev.config;


import kz.iitu.itse1909.borangaziyev.database.Booking;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;


@Configuration
@Profile(value = "dev")
@PropertySource(value = "classpath:defaults.properties")
public class CustomerConfig {

    @Autowired
    private Environment environment;


    @Bean
    @Scope(value = "prototype")
    public Customer customer() {
        // setting default customer settings
        Customer customer = new Customer();
        customer.setEmail(environment.getProperty("customer.email"));
        customer.setFirstName(environment.getProperty("customer.firstName"));
        customer.setLastName(environment.getProperty("customer.lastName"));
        customer.setVip(Boolean.parseBoolean(environment.getProperty("customer.isVip")));

        return customer;
    }

    @Bean
    @DependsOn({"seat", "customer", "movieSession"})
    public Booking booking() {
        Booking booking = new Booking();
        booking.setCustomer(customer());
        booking.setSession(new MovieSession());
        booking.setSeat(new Seat());
        return booking;
    }




}
