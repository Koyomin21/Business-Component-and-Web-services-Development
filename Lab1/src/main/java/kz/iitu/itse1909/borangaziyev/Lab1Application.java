package kz.iitu.itse1909.borangaziyev;

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

        System.out.println("Movies: " + movieService.getAllMovies());
        System.out.println("Customers: " + customerService.getAllCustomers());
//
//        System.out.println("Customers: " + customerService.getAllCustomers());

    }



}
