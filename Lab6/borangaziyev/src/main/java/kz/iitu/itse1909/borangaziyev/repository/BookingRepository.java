package kz.iitu.itse1909.borangaziyev.repository;


import kz.iitu.itse1909.borangaziyev.database.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
