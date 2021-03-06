package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import kz.iitu.itse1909.borangaziyev.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.lang.annotation.*;


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class Lab2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab2Application.class, args);
        Config config = context.getBean(Config.class);
        config.runServiceMethods(context);
    }

}
