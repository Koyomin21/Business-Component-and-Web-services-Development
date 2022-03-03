package kz.iitu.itse1909r.nugmanova.Configuration;


import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;

import kz.iitu.itse1909r.nugmanova.Database.Customer;
import kz.iitu.itse1909r.nugmanova.ElviraNugmanovaItse1909RApplication;
import kz.iitu.itse1909r.nugmanova.Service.AuthorService;
import kz.iitu.itse1909r.nugmanova.Service.BookService;
import kz.iitu.itse1909r.nugmanova.Service.CustomerService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


@Configuration
@Profile(value = "dev")
@Import({BookConfiguration.class, AuthorConfiguration.class, HibernateConfiguration.class})
public class AppConfiguration {



    private static ApplicationContext applicationContext;
    static BookService bookService = null;
    static AuthorService authorService = null;
    static CustomerService customerService = null;
    static Customer customer = null;




    public void RunningApplicationMethods(ApplicationContext applicationContext) {
//        applicationContext = SpringApplication.run(ElviraNugmanovaItse1909RApplication.class, args);
//        ApplicationContext configContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        bookService = applicationContext.getBean(BookService.class);
        authorService = applicationContext.getBean(AuthorService.class);
        customerService = applicationContext.getBean(CustomerService.class);
        customer = applicationContext.getBean(Customer.class);
        Book book = applicationContext.getBean(Book.class);
        Author author = applicationContext.getBean(Author.class);
        System.out.println(" //---------- DEFINING SOME OF THE DEFAULT VALUES CHECK: ----------//");
        System.out.println(book);
        System.out.println(author);
        // implementing the service logic
        System.out.println(" //---------- STUPID SERVICE LOGIC WHICH IS NECESSARY: ----------//");
        System.out.println("You have books: " + bookService.getAllBooks().size());
        bookService.getAllBooks().stream().forEach(b -> System.out.println(b.toString()));
        System.out.println("You have authors: " + authorService.getAllAuthors().size());
        authorService.getAllAuthors().stream().forEach(b -> System.out.println(b.toString()));
        System.out.println("---Philosophical novels:---");
        bookService.getBooksByGenre("Philosophical Novel").stream().forEach(b -> System.out.println(b.toString()));
        System.out.println(" //------------------ MY SMART SERVICE LOGIC: ------------------//");
        System.out.println("BOOKS SORTED BY RANK:");
        bookService.getBooksSortedByRank().stream().forEach(b -> System.out.println(b.toString()));
        // checking if the customer is present in the system
        System.out.println(customerService.loginCustomer("elvira@mail.ru", "pomidor"));
        System.out.println(customerService.loginCustomer("aida@mail.ru", "lalala"));
        System.out.println("Getting the author of 'The Fall': " + bookService.getAuthorByBookId(2).toString());
        // picking all the books by one author
        System.out.println("Getting all the books by Alber Camus: " + bookService.getBooksByAuthorId(1));
        System.out.println("Registering a customer 'aida@mail.ru' with 'lalala'");
        // registering a new user
        customerService.signInCustomer("aida@mail.ru", "lalala");
        System.out.println(customerService.loginCustomer("aida@mail.ru", "lalala"));
        // deleting by email X password pair
        System.out.println("Deleting 'aida@mail.ru' user: ... " + customerService.deleteCustomer("aida@mail.ru", "lalala"));

        // new Authors
        List<Author> authors = Arrays.asList(
                new Author("Name1", "SurName1", LocalDate.of(1956, 2, 3), true),
                new Author("Name2", "SurName2", LocalDate.of(1936, 7, 8), true),
                new Author("Name3", "SurName3", LocalDate.of(1952, 4, 9), false),
                new Author("Name4", "SurName4", LocalDate.of(1982, 6, 1), true),
                new Author("Name5", "SurName5", LocalDate.of(1972, 1, 4), false),
                new Author("Name6", "SurName6", LocalDate.of(1922, 4, 3), false)
        );

        // batch insert authors
        authorService.batchInsertAuthors(authors);
        System.out.println(authorService.getAllAuthors());
        // Updating all Authors
        authorService.batchUpdateAuthorsAwarded(authorService.getAllAuthors(), true);
        authorService.getAllAuthors().forEach(s -> System.out.println(s.getName() + " : " + s.getAwarded()));



    }
}
