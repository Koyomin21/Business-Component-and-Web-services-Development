package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.AuthorRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AuthorServiceTest {
    @Mock
    AuthorRepositoryImpl authorRepository;
    @InjectMocks
    AuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAuthorByAuthor_Id() {
        when(authorRepository.findAuthorById(anyInt())).thenReturn(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE));

        Author result = authorService.findAuthorByAuthor_Id(Integer.valueOf(0));
        Assertions.assertEquals(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), result);
    }

    @Test
    void testGetAllAuthors() {
        when(authorRepository.findAll()).thenReturn(Arrays.<Author>asList(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE)));

        List<Author> result = authorService.getAllAuthors();
        Assertions.assertEquals(Arrays.<Author>asList(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE)), result);
    }

    @Test
    void testBatchInsertAuthors() {
        authorService.batchInsertAuthors(Arrays.<Author>asList(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE)));
    }

    @Test
    void testBatchUpdateAuthorsAwarded() {
        authorService.batchUpdateAuthorsAwarded(Arrays.<Author>asList(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE)), true);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme