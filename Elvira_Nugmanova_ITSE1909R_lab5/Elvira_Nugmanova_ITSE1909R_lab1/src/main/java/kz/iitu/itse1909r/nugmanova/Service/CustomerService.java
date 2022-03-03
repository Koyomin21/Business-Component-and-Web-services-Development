package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.AOP.AuthorizationRequired;
import kz.iitu.itse1909r.nugmanova.Database.Customer;
import kz.iitu.itse1909r.nugmanova.Repository.CustomerRepository;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepositoryImpl customerRepository = null;
    // by setter
    @Autowired
    public void setCustomerRepository(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void signInCustomer(String email, String password) {
        customerRepository.signInCustomer(new Customer(email, password));
    }

    // smart service logic
    public String loginCustomer(String email, String password) {
        Customer customer = customerRepository.getCustomerByEmailAndPassword(email, password);
        if (customer != null) {
            return customer.toString();
        }
        else {
            return String.format("Sorry, there is no such user as %s with password %s", email, password);
        }
    }

    @AuthorizationRequired
    public String deleteCustomer(String email, String password) {
        Customer customer = customerRepository.getCustomerByEmailAndPassword(email, password);
        if (customer != null) {
            customerRepository.delete(customer);
            return "The customer has been deleted!";
        }
        else {
            return String.format("Sorry, there is no such user as %s with password %s", email, password);
        }
    }

}
