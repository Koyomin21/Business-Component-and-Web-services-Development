package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieSessionRepository extends CrudRepository<MovieSession, Long> {
    List<MovieSession> findAllByPriceBetween(int startPrice, int endPrice);
}
