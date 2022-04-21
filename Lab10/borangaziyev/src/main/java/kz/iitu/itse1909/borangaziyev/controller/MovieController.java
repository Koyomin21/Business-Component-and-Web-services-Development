package kz.iitu.itse1909.borangaziyev.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.jms.JmsService;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private MovieService movieService;
    private ObjectMapper om;

    @Autowired
    private JmsService jmsService;

    @Autowired
    public MovieController(MovieService movieService, ObjectMapper om) {
        this.movieService = movieService;
        this.om = om;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        return movies;

    }

    @GetMapping("sortedByYear/")
    @ResponseBody
    public List<Movie> getMoviesSortedByPublishedYear() {
        List<Movie> movies = movieService.getMoviesSortedByPublishedYear();

        if(movies == null) throw new RuntimeException("Null Value");
        if(movies.isEmpty()) throw new RuntimeException("Empty Movies");

        return movies;
    }


    @PostMapping("addMovies/")
    public @ResponseBody String addNewMovies(@RequestBody String moviesListJson) throws JsonProcessingException {
        System.out.println(moviesListJson);
        String result = "";

        List<Movie> moviesToAdd = om.readValue(moviesListJson, new TypeReference<List<Movie>>(){});

        if(moviesToAdd == null || moviesToAdd.isEmpty())
        {
            throw new RuntimeException("Null or empty");
        }
        movieService.addNewMovies(moviesToAdd);
        result = "Successfully saved";
        return result;
    }

    @DeleteMapping("delete/{id:[0-9]+}")
    public @ResponseBody String deleteMovie(@PathVariable long id) {

        movieService.deleteMovie(id);


        movieService.deleteMovie(id);

        return "Successfully deleted";
    }


}
