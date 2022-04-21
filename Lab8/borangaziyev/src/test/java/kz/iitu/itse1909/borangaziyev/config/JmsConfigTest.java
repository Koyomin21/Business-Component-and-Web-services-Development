package kz.iitu.itse1909.borangaziyev.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JmsConfigTest {
    JmsConfig jmsConfig = new JmsConfig();

    @Test
    void testConnectionFactory() {


    }

    @Test
    void testJacksonJmsMessageConverter() {
        MessageConverter result = jmsConfig.jacksonJmsMessageConverter();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme