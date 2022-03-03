package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.AOP.AuthorizationRequired;
import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;
import kz.iitu.itse1909r.nugmanova.Repository.AuthorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.BookRepository;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.AuthorRepositoryImpl;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    // by field
    @Autowired
    BookRepositoryImpl bookRepository;
    @Autowired
    AuthorRepositoryImpl authorRepository;

    // stupid service logic: selects
    @AuthorizationRequired
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByYear(Integer year) {
        return bookRepository.getBooksByYear(year);
    }

    @Cacheable(value = "books", key = "#book.bookId")
    public Book getBookById(Integer id) {
        return bookRepository.findBookById(id);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.getBooksByGenre(genre);
    }

    // smart service logic: complex selects

    public Author getAuthorByBookId(Integer id) {
        Book book = bookRepository.findBookById(id);
        return book.getAuthor();
    }

    public List<Book> getBooksByAuthorId(Integer id) {
        Author author = authorRepository.findAuthorById(id);
        return author.getBooks();
    }

    public List<Book> getBooksSortedByRank() {
        return bookRepository.findAll().stream().sorted(Comparator.comparing(
                b -> b.getRank(), Comparator.reverseOrder())).collect(Collectors.toList());
    }


}
