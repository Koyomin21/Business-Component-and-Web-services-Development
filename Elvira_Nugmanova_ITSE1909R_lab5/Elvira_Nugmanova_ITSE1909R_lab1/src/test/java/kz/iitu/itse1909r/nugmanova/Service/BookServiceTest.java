package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.AuthorRepositoryImpl;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.BookRepositoryImpl;
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

class BookServiceTest {
    @Mock
    BookRepositoryImpl bookRepository;
    @Mock
    AuthorRepositoryImpl authorRepository;
    @InjectMocks
    BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));

        List<Book> result = bookService.getAllBooks();
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }

    @Test
    void testGetBooksByYear() {
        when(bookRepository.getBooksByYear(anyInt())).thenReturn(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));

        List<Book> result = bookService.getBooksByYear(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }

    @Test
    void testGetBookById() {
        when(bookRepository.findBookById(anyInt())).thenReturn(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0)));

        Book result = bookService.getBookById(Integer.valueOf(0));
        Assertions.assertEquals(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0)), result);
    }

    @Test
    void testGetBooksByGenre() {
        when(bookRepository.getBooksByGenre(anyString())).thenReturn(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));

        List<Book> result = bookService.getBooksByGenre("genre");
        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
    }

    @Test
    void testGetAuthorByBookId() {
        when(bookRepository.findBookById(anyInt())).thenReturn(new Book(null, new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), null, null, null, null, null));

        Author result = bookService.getAuthorByBookId(Integer.valueOf(0));
        Assertions.assertEquals(new Author("name", "surname", LocalDate.of(2022, Month.MARCH, 2), Boolean.TRUE), result);
    }

    @Test
    void testGetBooksByAuthorId() {
        Author author = new Author();
        author.setBooks(Arrays.<Book>asList(new Book()));
        when(authorRepository.findAuthorById(anyInt())).thenReturn(author);

        List<Book> result = bookService.getBooksByAuthorId(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Book>asList(new Book()), result);
    }

    @Test
    void testGetBooksSortedByRank() {
        when(bookRepository.findAll()).thenReturn(Arrays.<Book>asList(new Book(null, null, null, null, null, null, Double.valueOf(0))));

        List<Book> result = bookService.getBooksSortedByRank();
        Assertions.assertEquals(Arrays.<Book>asList(new Book(null, null, null, null, null, null, Double.valueOf(0))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme