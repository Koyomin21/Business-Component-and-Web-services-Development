package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Seat;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Seat seat() {
        return new Seat();
    }

//    @Bean
//    public MovieService movieService() {
//        return new MovieService();
//    }
}
