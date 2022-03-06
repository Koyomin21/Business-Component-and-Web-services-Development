package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionRepository extends CrudRepository<MovieSession, Long> {
    List<MovieSession> findAllByPriceBetween(int startPrice, int endPrice);
    List<MovieSession> findAllByMovieTitle(String title);

    @Transactional
    @Lock(LockModeType.READ)
    @Query("select s from #{#entityName} s where s.sessionDate between :startDate and :endDate")
    List<MovieSession> getMovieSessionsBySessionDateBetween(@Param("startDate") LocalDate startDate,
                                                            @Param("endDate") LocalDate endDate);

}
