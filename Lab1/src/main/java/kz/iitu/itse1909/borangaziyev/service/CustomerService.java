package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repo;


    @Autowired
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }


    public List<Customer> getAllCustomers() {
        return (List<Customer>) repo.findAll();
    }



}
