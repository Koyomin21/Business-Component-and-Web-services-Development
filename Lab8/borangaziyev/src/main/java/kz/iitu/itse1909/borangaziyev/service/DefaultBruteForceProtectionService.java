package kz.iitu.itse1909.borangaziyev.service;

import kz.iitu.itse1909.borangaziyev.database.User;
import kz.iitu.itse1909.borangaziyev.repository.UserRepository;
import kz.iitu.itse1909.borangaziyev.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;




@Service("bruteForceProtectionService")
public class DefaultBruteForceProtectionService {

    @Value("${security.failedlogin.count}")
    private int maxFailedLogins;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Value("${bruteforce.cache.max}")
    private int cacheMaxLimit;

    private final ConcurrentHashMap< String, FailedLogin > cache;

    public DefaultBruteForceProtectionService() {
        this.cache = new ConcurrentHashMap < > (cacheMaxLimit); //setting max limit for cache
    }


    public void registerLoginFailure(String username) {

        User user = userRepository.getUserByUsername(username);
        if (user != null && !user.isLoginDisabled()) {
            int failedCounter = user.getFailedLoginAttempts();
            if (maxFailedLogins < failedCounter + 1) {
                user.setLoginDisabled(true); //disabling the account
            } else {
                //let's update the counter
                user.setFailedLoginAttempts(failedCounter + 1);
            }
            userRepository.save(user);
        }
    }


    public void resetBruteForceCounter(String username) {
        User user = getUser(username);
        if (user != null) {
            user.setFailedLoginAttempts(0);
            user.setLoginDisabled(false);
            userRepository.save(user);
        }
    }


    public boolean isBruteForceAttack(String username) {
        User user = getUser(username);
        if (user != null) {
            return user.getFailedLoginAttempts() >= maxFailedLogins ? true : false;
        }
        return false;
    }

    protected FailedLogin getFailedLogin(final String username) {
        FailedLogin failedLogin = cache.get(username.toLowerCase());

        if (failedLogin == null) {
            //setup the initial data
            failedLogin = new FailedLogin(0, LocalDateTime.now());
            cache.put(username.toLowerCase(), failedLogin);
            if (cache.size() > cacheMaxLimit) {

                // add the logic to remve the key based by timestamp
            }
        }
        return failedLogin;
    }

    private User getUser(final String username) {
        return userRepository.getUserByUsername(username);
    }

    public int getMaxFailedLogins() {
        return maxFailedLogins;
    }

    public void setMaxFailedLogins(int maxFailedLogins) {
        this.maxFailedLogins = maxFailedLogins;
    }



    public class FailedLogin {

        private int count;
        private LocalDateTime date;

        public FailedLogin() {
            this.count = 0;
            this.date = LocalDateTime.now();
        }

        public FailedLogin(int count, LocalDateTime date) {
            this.count = count;
            this.date = date;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }
    }
}