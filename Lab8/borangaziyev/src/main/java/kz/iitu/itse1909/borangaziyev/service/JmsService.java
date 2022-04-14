package kz.iitu.itse1909.borangaziyev.service;

import antlr.debug.MessageListener;
import kz.iitu.itse1909.borangaziyev.database.Movie;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JmsService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendJmsMessage(String message, Collection<Object> objects) {
        jmsTemplate.convertAndSend("jmsDestination", new JmsMessage(message, objects));
    }


    @JmsListener(destination = "jmsDestination", containerFactory = "myFactory")
    public void receiveJmsMessage(JmsMessage jmsMessage) {
        if(jmsMessage != null)
        {
            System.out.println("Message: " + jmsMessage.getMessage());
            System.out.println("Collection of Objects: " + jmsMessage.getObjectCollection());
        } else {
            System.out.println("Jms message is null");
        }
    }

}



@Data
class JmsMessage {
    private String message;
    private Collection<Object> objectCollection;

    public JmsMessage(String message, Collection<Object> objectCollection) {
        this.message = message;
        this.objectCollection = objectCollection;
    }

    public JmsMessage(){}
}

