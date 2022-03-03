package kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository;

import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookRepositoryImplTest {
    @Mock
    SessionFactory sessionFactory;
    @InjectMocks
    BookRepositoryImpl bookRepositoryImpl;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        Session session = Mockito.mock(Session.class);
        Query query = Mockito.mock(Query.class);


        when(session.createQuery("from Book b")).thenReturn(query);
        when(query.list()).thenReturn(Arrays.<Book>asList(new Book()));
        List<Book> result = bookRepositoryImpl.findAll();
        Assertions.assertEquals(Arrays.<Book>asList(new Book()), result);
    }

    @Test
    void testFindBookById() {
        Book result = bookRepositoryImpl.findBookById(Integer.valueOf(0));
        Assertions.assertEquals(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0)), result);
    }

    @Test
    void testGetBooksByYear() {
        List<Book> result = bookRepositoryImpl.getBooksByYear(0);
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }

    @Test
    void testGetBooksByGenre() {
        List<Book> result = bookRepositoryImpl.getBooksByGenre("genre");
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }

    @Test
    void testGetBooksSortedByRank() {
        List<Book> result = bookRepositoryImpl.getBooksSortedByRank();
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }

    @Test
    void testGetBooksByAuthorId() {
        List<Book> result = bookRepositoryImpl.getBooksByAuthorId(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme