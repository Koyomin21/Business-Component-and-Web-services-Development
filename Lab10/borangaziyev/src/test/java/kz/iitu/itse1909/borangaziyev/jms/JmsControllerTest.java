package kz.iitu.itse1909.borangaziyev.jms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class JmsControllerTest {
    @Mock
    JmsService jmsService;
    @InjectMocks
    JmsController jmsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetMessage() {
        when(jmsService.getFromQueue()).thenReturn("getFromQueueResponse");

        String result = jmsController.getMessage();
        Assertions.assertEquals("getFromQueueResponse", result);
    }

    @Test
    void testSendMessage() {
        String result = jmsController.sendMessage("body");
        Assertions.assertEquals("Successfully sent", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme