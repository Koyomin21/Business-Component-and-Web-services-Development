package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BorangaziyevApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BorangaziyevApplication.class, args);
		Config conf = context.getBean(Config.class);
		conf.runServiceMethods(context);
	}

}
