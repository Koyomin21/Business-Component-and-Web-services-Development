package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab3Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab3Application.class, args);
        Config config = context.getBean(Config.class);
        config.runServiceMethods(context);
    }

}
