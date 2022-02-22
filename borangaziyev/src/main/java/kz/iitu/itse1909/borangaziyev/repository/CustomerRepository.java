package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.database.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
