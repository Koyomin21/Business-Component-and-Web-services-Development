package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.*;
import kz.iitu.itse1909.borangaziyev.repository.BookingRepository;
import kz.iitu.itse1909.borangaziyev.service.*;
import kz.iitu.itse1909.borangaziyev.validators.converters.StringToHallConverter;
import kz.iitu.itse1909.borangaziyev.validators.formatters.FormatterServiceBeanFactory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Log
@Configuration
@Import({CacheConfig.class, HibernateConfig.class, Swagger2Fox.class})
@Profile(value = "dev")
public class Config {

    @Autowired
    FormatterServiceBeanFactory formatterService;

    @Bean
    @DependsOn("hall")
    public Seat seat() {
        return new Seat();
    }

    @Bean
    public Hall hall() {
        return new Hall();
    }

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean =
                new ConversionServiceFactoryBean();
        Set<Converter> convs = new HashSet<>();
        convs.add(new StringToHallConverter());

        conversionServiceFactoryBean.setConverters(convs);
        conversionServiceFactoryBean.afterPropertiesSet();

        return conversionServiceFactoryBean;

    }

}
