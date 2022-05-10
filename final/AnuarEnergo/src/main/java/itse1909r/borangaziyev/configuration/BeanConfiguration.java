package itse1909r.borangaziyev.configuration;

import itse1909r.borangaziyev.aop.CheckArguments;
import itse1909r.borangaziyev.aop.ExecutionTimeLogger;
import itse1909r.borangaziyev.converters.StringToUser;
import itse1909r.borangaziyev.model.*;
import itse1909r.borangaziyev.repository.UserRepository;
import itse1909r.borangaziyev.service.ElectricityBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

@Configuration
@PropertySource("classpath:user.properties")
public class BeanConfiguration {

    private Environment environment;

    @Value("${user.username}")
    private String defaultUsername;
    @Value("${user.password}")
    private String defaultPassword;
    @Value("${user.firstName}")
    private String defaultFirstName;
    @Value("${user.lastName}")
    private String defaultLastName;


    @Autowired
    public BeanConfiguration(Environment environment) {
        this.environment = environment;
    }



    @Bean
    @Lazy
    public User user() {
        User user = new User();
        user.setUserId(0);
        user.setFirstName(defaultFirstName);
        user.setLastName(defaultLastName);
        user.setPassword(defaultPassword);
        user.setUsername(defaultUsername);

        return user;
    }


    @Bean
    @Scope(value = "prototype")
    public Provider provider() {
        Provider provider = new Provider();
        provider.setProviderId(0);
        provider.setName("Provider Def");
        return provider;
    }


    @Bean
    @DependsOn("user")
    public Building building() {
        Building building = new Building();
        building.setBuildingId(0);
        building.setAddress("Default Address");
        building.setUserId(user().getUserId());
        return building;
    }


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ElectricityBillService billService;

    @Bean
    public void testRepo() {
        System.out.println(billService.getAllBills());
    }


}
