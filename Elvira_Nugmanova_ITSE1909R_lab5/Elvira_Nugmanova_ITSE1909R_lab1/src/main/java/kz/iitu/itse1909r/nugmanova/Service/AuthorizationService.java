package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Customer;
import kz.iitu.itse1909r.nugmanova.Repository.CustomerRepository;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
    private CustomerRepositoryImpl repo;


    public Customer getCustomerByEmail(String email) {
        Customer customer = repo.getCustomerByEmail(email);
        if(customer == null) {
            throw new NullPointerException();
        }

        return customer;
    }
}
