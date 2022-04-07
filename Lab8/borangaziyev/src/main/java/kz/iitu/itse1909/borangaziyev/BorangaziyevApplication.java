package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(Config.class)
public class BorangaziyevApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorangaziyevApplication.class, args);
	}

}
