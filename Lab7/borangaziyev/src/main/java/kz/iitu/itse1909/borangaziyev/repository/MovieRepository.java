package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.database.Movie;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findMoviesByDescriptionContaining(String description);
    List<Movie> findMoviesWithNoDescription();

    @Modifying
    @Lock(LockModeType.WRITE)
    @Query("update #{#entityName} m set m.title = :title where m.movieId = :id")
    int setTitleByMovieId(@Param("id") int id,
                          @Param("title") String title);

}
