package kz.iitu.itse1909.borangaziyev.jms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

import java.util.Queue;

import static org.mockito.Mockito.*;

class JmsServiceTest {
    @Mock
    JmsTemplate jmsTemplate;
    @Mock
    Queue<String> queue;
    @InjectMocks
    JmsService jmsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSendJmsMessage() {
        jmsService.sendJmsMessage("message");
    }

    @Test
    void testReceiveJmsMessage() {
        jmsService.receiveJmsMessage("message");
    }

    @Test
    void testGetFromQueue() {
        String result = jmsService.getFromQueue();
        Assertions.assertNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme