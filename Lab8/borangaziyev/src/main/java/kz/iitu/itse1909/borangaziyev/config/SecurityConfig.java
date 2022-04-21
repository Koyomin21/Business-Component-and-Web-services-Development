package kz.iitu.itse1909.borangaziyev.config;

import kz.iitu.itse1909.borangaziyev.security.CustomAuthenticationFailureHandler;
import kz.iitu.itse1909.borangaziyev.security.MyBasicAuthenticationEntryPoint;
import kz.iitu.itse1909.borangaziyev.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyBasicAuthenticationEntryPoint entryPoint;
    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(entryPoint)
                .and()
                .formLogin()
                    .failureHandler(failureHandler)
                    .usernameParameter("username")
                    .defaultSuccessUrl("/movies/all/")
                    .permitAll()
                .and()
                .rememberMe()
                    .rememberMeCookieDomain("domain")
                    .rememberMeCookieName("custom-remember-me-cookie")
                    .tokenValiditySeconds(2000)
                    .useSecureCookie(true)
                .and()
                .logout().permitAll();
    }
}
