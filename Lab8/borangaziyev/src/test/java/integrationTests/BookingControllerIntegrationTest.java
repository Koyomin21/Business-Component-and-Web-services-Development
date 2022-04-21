package integrationTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.BorangaziyevApplication;
import kz.iitu.itse1909.borangaziyev.service.BookingService;
import kz.iitu.itse1909.borangaziyev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(classes = BorangaziyevApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String urlTemplate = "http://localhost:"+port+"/customer/";

    @MockBean
    private BookingService bookingService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;
}
