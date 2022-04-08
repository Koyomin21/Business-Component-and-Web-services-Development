package kz.iitu.itse1909.borangaziyev.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.exceptions.RestResponseEntityExceptionHandler;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private MovieService movieService;
    private ObjectMapper om;

    @Autowired
    public MovieController(MovieService movieService, ObjectMapper om) {
        this.movieService = movieService;
        this.om = om;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Movie> getAllMovies() {
        try {
            List<Movie> movies = movieService.getAllMovies();

            return movies;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
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
    public @ResponseBody String addNewMovies(@RequestBody String moviesListJson)  {
        System.out.println(moviesListJson);
        String result = "";
        try {
            List<Movie> moviesToAdd = om.readValue(moviesListJson, new TypeReference<List<Movie>>(){});

            if(moviesToAdd == null || moviesToAdd.isEmpty())
            {
                throw new RuntimeException("Null or empty");
            }
            movieService.addNewMovies(moviesToAdd);
            result = "Successfully saved";
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ConstraintViolationException e) {
            result = "Constration Violation! Enter good input!";
        }

        return result;
    }

    @DeleteMapping("delete/{id:[0-9]+}")
    public @ResponseBody String deleteMovie(@PathVariable long id) {
        try {
            movieService.deleteMovie(id);
        } catch (EmptyResultDataAccessException e) {
            return "No movie with such id!";
        }

        movieService.deleteMovie(id);

        return "Successfully deleted";
    }


}
