package kz.iitu.itse1909r.nugmanova.Configuration;

import kz.iitu.itse1909r.nugmanova.Database.Author;
import kz.iitu.itse1909r.nugmanova.Database.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@Configuration
@Profile(value = "dev")
@PropertySource(value = "classpath:author.properties")
public class AuthorConfiguration {
    @Autowired
    private Environment environment;

    @Lazy
    @Bean(name = "author")
    @Scope("prototype")
    Author author() {
        Author author = new Author();
        author.setName(environment.getProperty("author.name"));
        author.setSurname(environment.getProperty("author.surname"));
        author.setAwarded(Boolean.valueOf(environment.getProperty("author.awarded")));
        author.setDob(LocalDate.parse(environment.getProperty("author.dob")));
        return author;
    }


}
