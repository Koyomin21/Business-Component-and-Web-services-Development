package kz.iitu.itse1909.borangaziyev.repository;


import kz.iitu.itse1909.borangaziyev.database.Customer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CustomerRepo {

    @Resource(name = "entityManagerFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public List<Customer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Customer c").list();
    }

    @Transactional
    public Customer findById(Long id) {
        return sessionFactory.getCurrentSession().find(Customer.class, id);
    }
}
