package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import kz.iitu.itse1909.borangaziyev.database.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class ConfigTest {
    @Mock
    Logger log;
    @InjectMocks
    Config config;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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

    @Test
    void testConversionService() {
        ConversionServiceFactoryBean result = config.conversionService();
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme