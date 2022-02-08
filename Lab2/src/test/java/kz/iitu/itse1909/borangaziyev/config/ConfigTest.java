package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.Lab2Application;
import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepository;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepository;
import kz.iitu.itse1909.borangaziyev.repository.MovieSessionRepository;
import kz.iitu.itse1909.borangaziyev.service.BookingService;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ConfigTest {
    Config config = new Config();

    @Test
    void testSeat() {
        Seat result = config.seat();
        Assertions.assertEquals(new Seat(), result);
    }

    @Test
    void testHall() {
        Hall result = config.hall();
        Assertions.assertEquals(new Hall(), result);
    }

    @Test
    void testRunServiceMethods() {
        ApplicationContext context = SpringApplication.run(Lab2Application.class);
        config.runServiceMethods(context);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme