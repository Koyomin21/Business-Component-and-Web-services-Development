package kz.iitu.itse1909r.nugmanova;


import kz.iitu.itse1909r.nugmanova.Configuration.AppConfiguration;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.BookRepositoryImpl;
import kz.iitu.itse1909r.nugmanova.Repository.hibernateRepository.CustomerRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class ElviraNugmanovaItse1909RApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ElviraNugmanovaItse1909RApplication.class, args);
        AppConfiguration config = context.getBean(AppConfiguration.class);
        config.RunningApplicationMethods(context);

    }
}
