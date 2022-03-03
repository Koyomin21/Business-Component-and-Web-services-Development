package kz.iitu.itse1909r.nugmanova.Configuration;

import kz.iitu.itse1909r.nugmanova.Database.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import static org.mockito.Mockito.*;

class BookConfigurationTest {
    @Mock
    Environment environment;
    @InjectMocks
    BookConfiguration bookConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBook() {
        when(environment.getProperty("book.name")).thenReturn("name");
        when(environment.getProperty("book.rank")).thenReturn("1.0");
        when(environment.getProperty("book.description")).thenReturn("Default book description");
        when(environment.getProperty("book.year")).thenReturn("2022");
        when(environment.getProperty("book.price")).thenReturn("1000");
        when(environment.getProperty("book.genre")).thenReturn("Novel");
        Book result = bookConfiguration.book();
        Assertions.assertEquals(new Book("name", null, Integer.valueOf(2022), Integer.valueOf(1000), "Novel", "Default book description", Double.valueOf(1.0)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme