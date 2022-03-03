package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.AOP.AuthorizationRequired;
import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;
import kz.iitu.itse1909r.nugmanova.Repository.AuthorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.AuthorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepositoryImpl authorRepository = null;

    // by constructor
    @Autowired
    AuthorService(AuthorRepositoryImpl authorRepo) {
        authorRepository = authorRepo;
    }

    @AuthorizationRequired
    public Author findAuthorByAuthor_Id(Integer authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void batchInsertAuthors(List<Author> authors) {
        authorRepository.batchInsertAuthors(authors);
    }

    public void batchUpdateAuthorsAwarded(List<Author> authors, boolean awarded) {
        authorRepository.batchUpdateAuthorsAwarded(authors, awarded);
    }


}
