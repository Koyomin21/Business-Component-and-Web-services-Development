package kz.iitu.itse1909r.nugmanova.Configuration;


import kz.iitu.itse1909r.nugmanova.Database.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Profile(value = "dev")
@PropertySource(value = "classpath:book.properties")
public class BookConfiguration {

    @Autowired
    private Environment environment;


    @Bean(initMethod = "initSession", destroyMethod = "destroySession")
    @DependsOn(value="author")
    Book book() {
        Book book = new Book();
        book.setName(environment.getProperty("book.name"));
        book.setRank(Double.valueOf(environment.getProperty("book.rank")));
        book.setDescription(environment.getProperty("book.description"));
        book.setGenre(environment.getProperty("book.genre"));
        book.setPrice(Integer.valueOf(environment.getProperty("book.price")));
        book.setYear(Integer.valueOf(environment.getProperty("book.year")));
        return book;
    }

}
