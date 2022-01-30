package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Movie;
//import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository repo;

    @Autowired
    public void setMovieRepository(MovieRepository repo) {
        this.repo = repo;
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>)repo.findAll();
    }

    public List<Movie> getMoviesSortedByPublishedYear() {
        // getting movies from repository
        List<Movie> movies = (List<Movie>) repo.findAll();
        // sorting movies by published year
        List<Movie> sortedMovies = movies.stream()
                .sorted(Comparator.comparingInt(Movie::getPublishedYear))
                .collect(Collectors.toList());

        return sortedMovies;
    }







}
