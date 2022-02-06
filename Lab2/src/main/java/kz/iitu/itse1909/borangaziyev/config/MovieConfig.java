package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Movie;

import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Profile(value = "dev")
@PropertySource(value = "classpath:defaults.properties")
public class MovieConfig {

    @Autowired
    Environment environment;

    @Bean(name = "movie")
    @Lazy
    @Scope("prototype")
    Movie movie() {
        System.out.println("Lazy Movie Initialized with default parameters");
        Movie movie = new Movie();
        movie.setMovieId(Integer.parseInt(environment.getProperty("movie.id")));
        movie.setTitle(environment.getProperty("movie.title"));
        movie.setDescription(environment.getProperty("movie.description"));
        movie.setMinutes(Integer.parseInt(environment.getProperty("movie.minutes")));
        movie.setPublishedYear(Integer.parseInt(environment.getProperty("movie.publishedYear")));

        return movie;
    }

    @DependsOn(value="movie")
    @Bean(initMethod = "initSession", destroyMethod = "destroySession")
    @Scope(value = "prototype")
    MovieSession movieSession() {
        MovieSession session = new MovieSession();
        session.setMovie(movie());
        return session;
    }



    // Movie Session implements init and destroy methods through interfaces


}
