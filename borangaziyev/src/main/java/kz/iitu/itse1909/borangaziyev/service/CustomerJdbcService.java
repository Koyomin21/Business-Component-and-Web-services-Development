package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.repository.CustomerJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerJdbcService {
    @Autowired
    private CustomerJdbcRepository repo;

    public List<CustomerModel> getAllCustomers() {
        return repo.getAllCustomers();
    }

    public List<CustomerModel> getVipCustomersFromSessionByMovieId(long id) {
//        List<CustomerModel> customers = repo.();
    }
}
