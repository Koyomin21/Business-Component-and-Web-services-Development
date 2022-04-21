package kz.iitu.itse1909.borangaziyev.service;


import kz.iitu.itse1909.borangaziyev.database.User;
import kz.iitu.itse1909.borangaziyev.repository.UserRepository;
import kz.iitu.itse1909.borangaziyev.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        boolean enabled = !user.isAccountVerified();
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .disabled(user.isLoginDisabled())
                .authorities("USER").build();
        return userDetails;
    }

}
