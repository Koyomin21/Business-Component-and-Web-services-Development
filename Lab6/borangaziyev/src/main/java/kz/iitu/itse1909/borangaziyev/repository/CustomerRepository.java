package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.database.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer getCustomerByFirstNameAndLastName(String firstName, String lastName);
    Customer findCustomersByLastNameContaining(String name);

    @Transactional(readOnly = true)
    List<Customer> findAllNotVipCustomers();

    @Transactional(readOnly = true)
    @Query("select c from #{#entityName} c where c.firstName like %:name% or c.lastName like %:name%")
    List<Customer> findAllByFirstNameorLastNameContaining(@Param("name") String name);

}
