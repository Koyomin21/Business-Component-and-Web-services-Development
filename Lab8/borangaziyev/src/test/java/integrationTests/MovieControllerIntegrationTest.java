package integrationTests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1909.borangaziyev.BorangaziyevApplication;

import kz.iitu.itse1909.borangaziyev.controller.MovieController;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.hamcrest.Matchers.equalTo;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
@SpringBootTest(classes = BorangaziyevApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String urlTemplate = "http://localhost:"+port;

    @MockBean
    private MovieService movieService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @Test
    void testGetAllMovies() throws Exception {
        List<Movie> movieList = Arrays.asList(new Movie());
        when(movieService.getAllMovies()).thenReturn(movieList);

        mockMvc.perform(get(urlTemplate + "/movies/all"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(om.writeValueAsString(movieList))));

        verify(movieService).getAllMovies();
    }

    @Test
    void testGetMoviesSortedByPublishedYear() throws Exception {
        List<Movie> movieList = Arrays.asList(new Movie());
        when(movieService.getMoviesSortedByPublishedYear()).thenReturn(movieList);

        mockMvc.perform(get(urlTemplate + "/movies/sortedByYear/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(om.writeValueAsString(movieList))));

        verify(movieService.getMoviesSortedByPublishedYear());
    }

    @Test
    void testAddNewMovies() throws Exception {
        List<Movie> movieList = Arrays.asList(new Movie(), new Movie());

        String moviesListJson = om.writeValueAsString(movieList);

        mockMvc.perform(post(urlTemplate + "/movies/addMovies/").content(moviesListJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully saved"));

        verify(movieService).addNewMovies(movieList);
    }

    @Test
    void testDeleteMovie() throws Exception {
        int id = 1;

        mockMvc.perform(delete(urlTemplate + "/movies/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully deleted"));

        verify(movieService).deleteMovie(id);
    }

}
