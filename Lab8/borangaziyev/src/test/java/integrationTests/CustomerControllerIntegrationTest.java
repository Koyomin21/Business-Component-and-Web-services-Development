package integrationTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.BorangaziyevApplication;
import kz.iitu.itse1909.borangaziyev.database.Customer;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = BorangaziyevApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String urlTemplate = "http://localhost:"+port+"/customer/";

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;


    @Test
    void testGetAllCustomers() throws Exception {
        List<Customer> customerList = Arrays.asList(new Customer());
        String customerJsonList = om.writeValueAsString(customerList);


        when(customerService.getAllCustomers()).thenReturn(customerList);

        mockMvc.perform(get(urlTemplate+"all/"))
                .andExpect(status().isOk())
                .andExpect(content().string(customerJsonList));
        verify(customerService).getAllCustomers();
    }

    @Test
    void testUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setLastName("Last Name");
        customer.setFirstName("First Name");
        customer.setEmail("Email");
        int custId = 1;
        String jsonCustomer = om.writeValueAsString(customer);

        when(customerService.updateCustomer(custId, customer)).thenReturn(customer);


        mockMvc.perform(put(urlTemplate+"updCustomer/1").contentType(MediaType.APPLICATION_JSON).content(jsonCustomer))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonCustomer));

        verify(customerService).updateCustomer(custId, customer);
    }

    @Test
    void testCheckCustomerExistence() {

    }
}
