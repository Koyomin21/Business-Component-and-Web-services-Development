package kz.iitu.itse1909.borangaziyev.security;

import kz.iitu.itse1909.borangaziyev.service.DefaultBruteForceProtectionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Log
@Component
public class AuthSuccessListener
        implements ApplicationListener<AuthenticationSuccessEvent> {
    @Autowired
    private HttpServletRequest request;

    @Resource(name = "bruteForceProtectionService")
    private DefaultBruteForceProtectionService bruteForceProtectionService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        log.info("********* login successful for user " + username);
        bruteForceProtectionService.resetBruteForceCounter(username);
    }
}
