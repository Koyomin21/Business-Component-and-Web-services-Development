package kz.iitu.itse1909.borangaziyev;

import kz.iitu.itse1909.borangaziyev.config.Config;
import kz.iitu.itse1909.borangaziyev.service.JmsService;
import org.apache.activemq.network.jms.JmsMesageConvertor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@SpringBootApplication
@Import(Config.class)
public class BorangaziyevApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BorangaziyevApplication.class, args);
		JmsService service = context.getBean(JmsService.class);
		service.sendJmsMessage("Messaeg", new []Object);

	}

}
