package kz.iitu.itse1909.borangaziyev.repository;

import kz.iitu.itse1909.borangaziyev.database.Movie;
import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepo {

    @Resource(name = "entityManagerFactory")
    private SessionFactory sessionFactory;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Movie> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Movie m").list();
    }


    @Transactional
    public MovieSession getSessionById(long id) {
        return sessionFactory.getCurrentSession().find(MovieSession.class, id);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void batchInsertNewMovies(List<Movie> movies) {
        for(int i = 0; i < movies.size(); i++) {
            if(i > 0 && i % 6 == 0) {
                sessionFactory.getCurrentSession().flush();
                sessionFactory.getCurrentSession().clear();
            }

            sessionFactory.getCurrentSession().persist(movies.get(i));
        }
    }

    @Transactional(isolation = Isolation.DEFAULT)
    public void batchUpdateMovieSessionsDate(Map<MovieSession, LocalDate> sessionDateMap) {
        for(Map.Entry<MovieSession, LocalDate> entry: sessionDateMap.entrySet()) {
            MovieSession session = entry.getKey();
            LocalDate date = entry.getValue();

            session.setSessionDate(date);

            sessionFactory.getCurrentSession().update(session);
        }
    }


}
