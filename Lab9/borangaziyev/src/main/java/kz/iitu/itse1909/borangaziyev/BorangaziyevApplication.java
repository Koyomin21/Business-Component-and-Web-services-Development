package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import kz.iitu.itse1909.borangaziyev.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Import(Config.class)
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class BorangaziyevApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorangaziyevApplication.class, args);
	}

}
