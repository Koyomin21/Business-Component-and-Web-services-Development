package kz.iitu.itse1909r.nugmanova.Configuration;

import kz.iitu.itse1909r.nugmanova.Database.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

class AuthorConfigurationTest {
    @Mock
    Environment environment;
    @InjectMocks
    AuthorConfiguration authorConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAuthor() {
        when(environment.getProperty("author.name")).thenReturn("name");
        when(environment.getProperty("author.surname")).thenReturn("surname");
        when(environment.getProperty("author.awarded")).thenReturn(String.valueOf(true));
        when(environment.getProperty("author.dob")).thenReturn(String.valueOf(LocalDate.of(2022, Month.FEBRUARY, 07)));

        Author result = authorConfiguration.author();
        Assertions.assertEquals(new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 07), Boolean.TRUE), result);
    }
}
