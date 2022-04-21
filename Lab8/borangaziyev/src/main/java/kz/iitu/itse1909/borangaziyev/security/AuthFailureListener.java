package kz.iitu.itse1909.borangaziyev.security;

import kz.iitu.itse1909.borangaziyev.service.DefaultBruteForceProtectionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Log
@Component
public class AuthFailureListener implements
        ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    @Autowired
    private HttpServletRequest request;

    @Resource(name = "bruteForceProtectionService")
    private DefaultBruteForceProtectionService bruteForceProtectionService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String username = event.getAuthentication().getName();
        log.info("********* login failed for user "+username);
        bruteForceProtectionService.registerLoginFailure(username);

    }
}
