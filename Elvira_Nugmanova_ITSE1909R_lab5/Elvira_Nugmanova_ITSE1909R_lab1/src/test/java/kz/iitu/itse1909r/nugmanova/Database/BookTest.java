package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

class BookTest {
    @Mock
    Author author;
    @InjectMocks
    Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = book.toString();
        Assertions.assertEquals("BOOK NAME: null", result);
    }

    @Test
    void testInitSession() {
        book.initSession();
    }

    @Test
    void testDestroySession() {
        book.destroySession();
    }

    @Test
    void testSetBookId() {
        book.setBookId(Integer.valueOf(0));
    }

    @Test
    void testSetName() {
        book.setName("name");
    }

    @Test
    void testSetAuthor() {
        book.setAuthor(new Author("name", "surname", LocalDate.of(2022, Month.FEBRUARY, 1), Boolean.TRUE));
    }

    @Test
    void testSetYear() {
        book.setYear(Integer.valueOf(0));
    }

    @Test
    void testSetPrice() {
        book.setPrice(Integer.valueOf(0));
    }

    @Test
    void testSetGenre() {
        book.setGenre("genre");
    }

    @Test
    void testSetDescription() {
        book.setDescription("description");
    }

    @Test
    void testSetRank() {
        book.setRank(Double.valueOf(0));
    }

    @Test
    void testEquals() {
        boolean result = book.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = book.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        Book book = new Book("la", new Author(), 1, 1, "la", "la", 4.6);
        int result = book.hashCode();
        Assertions.assertEquals(book.hashCode(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme