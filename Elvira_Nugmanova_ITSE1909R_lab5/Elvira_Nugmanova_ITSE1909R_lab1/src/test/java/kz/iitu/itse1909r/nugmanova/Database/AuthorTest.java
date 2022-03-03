package kz.iitu.itse1909r.nugmanova.Database;

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

class AuthorTest {
    //Field dob of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    List<Book> books;
    @InjectMocks
    Author author;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = author.toString();
        Assertions.assertEquals("AUTHOR NAME: null null", result);
    }

//    @Test
//    void testSetAuthor_Id() {
//        author.setAuthor_Id(Integer.valueOf(0));
//    }

    @Test
    void testSetName() {
        author.setName("name");
    }

    @Test
    void testSetSurname() {
        author.setSurname("surname");
    }

    @Test
    void testSetDob() {
        author.setDob(LocalDate.of(2022, Month.FEBRUARY, 1));
    }

    @Test
    void testSetAwarded() {
        author.setAwarded(Boolean.TRUE);
    }

    @Test
    void testSetBooks() {
        author.setBooks(Arrays.<Book>asList(new Book("name", new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE), Integer.valueOf(0), Integer.valueOf(0), "genre", "description", Double.valueOf(0))));
    }

    @Test
    void testEquals() {
        boolean result = author.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = author.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = author.hashCode();
        Assertions.assertEquals(author.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme