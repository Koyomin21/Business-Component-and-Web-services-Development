package integrationTests;

import kz.iitu.itse1909.borangaziyev.BorangaziyevApplication;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BorangaziyevApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTestIntegration {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({"schema.sql", "data.sql"})
    @Test
    public void deleteMovie() {
        long id = 1;
        String response = this.restTemplate
                .getForObject("http://localhost:"+port+"movie/delete/1", String.class);

        Assertions.assertEquals(response, "Successfuly deleted");
    }
}
