package kz.iitu.itse1909r.nugmanova.Configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

class HibernateConfigurationTest {
    HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();

    @Test
    void testSessionFactory() {
        LocalSessionFactoryBean result = hibernateConfiguration.sessionFactory();
        String rs = result.toString();
        Assertions.assertEquals(rs, result.toString());
    }

    @Test
    void testDataSource() {
        DataSource result = hibernateConfiguration.dataSource();
        String rs = result.toString();

        Assertions.assertEquals(rs, result.toString());
    }

    @Test
    void testTransactionManager() {
        PlatformTransactionManager result = hibernateConfiguration.transactionManager();
        String rs = result.toString();

        Assertions.assertEquals(rs, result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme