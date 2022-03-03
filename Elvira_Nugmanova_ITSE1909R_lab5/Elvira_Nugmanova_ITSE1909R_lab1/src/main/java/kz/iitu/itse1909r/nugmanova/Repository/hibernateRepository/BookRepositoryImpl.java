package kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository;

import kz.iitu.itse1909r.nugmanova.Database.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl {

    @Autowired
    private SessionFactory sessionFactory;



    @Transactional(readOnly=true, rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ)
    public List<Book> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Book b").list();
    }

    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
//    @Cacheable("books")
    public Book findBookById(Integer id) {
        return sessionFactory.getCurrentSession().find(Book.class, id);
    }

//    @Cacheable("books")
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Book> getBooksByYear(int year) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book b WHERE year =:year")
                .setParameter("year", year)
                .list();
    }

//    @Cacheable("books")
    public List<Book> getBooksByGenre(String genre) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book b WHERE genre =:genre")
                .setParameter("genre", genre)
                .list();
    }

//    @Cacheable("books")
    public List<Book> getBooksSortedByRank() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book b ORDER BY b.rank")
                .list();
    }

    public List<Book> getBooksByAuthorId(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a.books from Author a WHERE a.authorId = :id")
                .setParameter("id", id)
                .list();
    }

}
