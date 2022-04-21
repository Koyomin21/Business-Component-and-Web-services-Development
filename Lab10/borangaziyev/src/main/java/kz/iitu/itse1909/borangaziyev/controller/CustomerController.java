package kz.iitu.itse1909.borangaziyev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "customer/")
public class CustomerController {

    private CustomerService customerService;
    private ObjectMapper objectMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }


    @GetMapping(value = "all/")
    @ResponseBody
    public List<Customer> getAllCustomers() {

        List<Customer> customers = customerService.getAllCustomers();
        return customers;

    }

    @PutMapping(value = "updCustomer/{id:[0-9]+}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") long customerId,
                                                   @Valid @RequestBody Customer customerDetails) {
        final Customer updatedCustomer = customerService.updateCustomer(customerId,customerDetails);
        return ResponseEntity.ok(updatedCustomer);
    }


    @RequestMapping(value = "checkCustomer",method = RequestMethod.HEAD)
    public ResponseEntity<Customer> checkCustomerExistence(@RequestParam long customerId) {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            Customer cust = customers.stream()
                    .filter(c -> c.getCustomerId() == customerId)
                    .findFirst()
                    .orElseThrow(()->new RuntimeException("No such Customer!"));

            return ResponseEntity.ok(cust);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
    }

    @RequestMapping(value = "options/", method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS");
        return ResponseEntity.ok("Success");
    }


}
