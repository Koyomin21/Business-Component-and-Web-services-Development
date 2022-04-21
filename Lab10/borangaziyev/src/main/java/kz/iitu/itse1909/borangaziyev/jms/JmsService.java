package kz.iitu.itse1909.borangaziyev.jms;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class JmsService {
    @Autowired
    private JmsTemplate jmsTemplate;

    private Queue<String> queue;

    public JmsService() {
        queue = new PriorityQueue<String>();
    }


    public void sendJmsMessage(String message) {
        jmsTemplate.convertAndSend("jmsDestination", message);
    }


    @JmsListener(destination = "jmsDestination", containerFactory = "connectionFactory")
    public void receiveJmsMessage(String message) {
        queue.add(message);
    }

    public String getFromQueue() {
        String res = queue.peek();
        if(res != null) queue.remove();

        return res;
    }


}



