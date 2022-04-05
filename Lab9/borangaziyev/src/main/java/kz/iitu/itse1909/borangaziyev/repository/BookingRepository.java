package kz.iitu.itse1909.borangaziyev.repository;


import kz.iitu.itse1909.borangaziyev.database.Booking;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    List<Booking> getBookingsByBookingDateAfter(LocalDate afterDate);

    List<Booking> getBookingsByBookingDateBefore(LocalDate beforeDate);

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<Booking> findPaidBookings();


}
