package kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository;


import kz.iitu.itse1909r.nugmanova.Database.Book;
import kz.iitu.itse1909r.nugmanova.Database.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly=true)
    public List<Customer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Customer c").list();
    }


    @Transactional
    public void signInCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Transactional(readOnly = true)
    public Customer getCustomerByEmailAndPassword(String email, String password) {
        Customer customer = null;

        try {
            customer = (Customer) sessionFactory.getCurrentSession()
                    .createQuery("from Customer c WHERE c.email = :email AND c.password = :pass")
                    .setParameter("email", email)
                    .setParameter("pass", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("NO RESULT!");
        }

        return customer;
    }


    @Transactional(isolation = Isolation.DEFAULT)
    public Customer getCustomerByEmail(String email){
        return (Customer) sessionFactory.getCurrentSession()
                .createQuery("from Customer c WHERE c.email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Transactional
    public void delete(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }

}
