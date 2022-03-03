//package kz.iitu.itse1909r.nugmanova.Controller;
//
//import kz.iitu.itse1909r.nugmanova.Database.Author;
//import kz.iitu.itse1909r.nugmanova.Database.Book;
//import kz.iitu.itse1909r.nugmanova.Service.BookService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//class BookControllerTest {
//    @Mock
//    BookService bookService;
//    @InjectMocks
//    BookController bookController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetAllBooks() {
//        when(bookService.getAllBooks()).thenReturn(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));
//
//        List<Book> result = bookController.getAllBooks();
//        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
//    }
//
//    @Test
//    void testGetBooksByAuthor() {
//        when(bookService.getBooksByAuthorId(anyInt())).thenReturn(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));
//
//        List<Book> result = bookController.getBooksByAuthor();
//        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
//    }
//
//    @Test
//    void testGetBooksByYear() {
//        when(bookService.getBooksByYear(anyInt())).thenReturn(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));
//
//        List<Book> result = bookController.getBooksByYear();
//        Assertions.assertEquals(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))), result);
//    }
//
//    @Test
//    void testGetBookById() {
//        when(bookService.getBookById(anyInt())).thenReturn(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0)));
//
//        Book result = bookController.getBookById(Integer.valueOf(0));
//        Assertions.assertEquals(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0)), result);
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme