//package kz.iitu.itse1909.borangaziyev.config;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//class HibernateConfigTest {
//    HibernateConfig hibernateConfig = new HibernateConfig();
//
//    @Test
//    void testSessionFactory() {
//        LocalSessionFactoryBean result = hibernateConfig.sessionFactory();
//        String res = result.toString();
//        Assertions.assertEquals(res, result.toString());
//    }
//
//    @Test
//    void testDataSource() {
//        DataSource result = hibernateConfig.dataSource();
//        String res = result.toString();
//
//        Assertions.assertEquals(res, result.toString());
//    }
//
//    @Test
//    void testTransactionManager() {
//        PlatformTransactionManager result = hibernateConfig.transactionManager();
//        String res = result.toString();
//        Assertions.assertEquals(res, result.toString());
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme