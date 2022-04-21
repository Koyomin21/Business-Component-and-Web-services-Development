package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import kz.iitu.itse1909.borangaziyev.jms.JmsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(Config.class)
public class BorangaziyevApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BorangaziyevApplication.class, args);
		JmsService service = context.getBean(JmsService.class);
		service.sendJmsMessage("Messaeg");
		service.sendJmsMessage("Второй ");
		service.sendJmsMessage("Третий");


	}

}
