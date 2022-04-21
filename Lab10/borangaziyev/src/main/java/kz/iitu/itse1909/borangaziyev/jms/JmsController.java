package kz.iitu.itse1909.borangaziyev.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jms/")
public class JmsController {

    @Autowired
    private JmsService jmsService;

    @GetMapping("getMessage/")
    public String getMessage() {
        return jmsService.getFromQueue();
    }

    @PostMapping("sendMessage/")
    public String sendMessage(@RequestBody String body) {
        jmsService.sendJmsMessage(body);
        return "Successfully sent";
    }
}
