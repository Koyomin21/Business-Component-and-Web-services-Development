package kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository;

import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class AuthorRepositoryImpl {


    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly=true)
    @Cacheable(value = "authors")
    public List<Author> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Author a").list();
    }

    @Transactional(readOnly = true)
//    @Cacheable(value = "cacheAuthorById", key = "#id")
    public Author findAuthorById(Integer id) {
        return sessionFactory.getCurrentSession().find(Author.class, id);
    }


    @CacheEvict(value = "authors", allEntries = true)
    @Transactional(propagation = Propagation.REQUIRED)
    public void batchInsertAuthors(List<Author> authors) {
        EntityManager entityManager = sessionFactory.getCurrentSession();
        int totalSize = authors.size();
        int BATCH_SIZE =  5;
        for(int i = 0; i < totalSize; i++) {
            if(i > 0 && i % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
            entityManager.persist(authors.get(i));
        }

    }

    @CachePut(value = "authors")
    @Transactional
    public void batchUpdateAuthorsAwarded(List<Author> authors, boolean awarded) {

        for(Author author:authors) {
            author.setAwarded(awarded);
            sessionFactory.getCurrentSession().update(author);
        }

    }

}
