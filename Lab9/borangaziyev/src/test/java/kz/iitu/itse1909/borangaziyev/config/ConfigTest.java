package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigTest {
    Config config = new Config();

    @Test
    void testSeat() {
        Seat result = config.seat();
        Assertions.assertEquals(new Seat(), result);
    }

    @Test
    void testHall() {
        Hall result = config.hall();
        Assertions.assertEquals(new Hall(), result);
    }

//    @Test
//    void testRunServiceMethods() {
//        ApplicationContext context = SpringApplication.run(Lab3Application.class);
//        config.runServiceMethods(context);
//    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme