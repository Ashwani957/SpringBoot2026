package com.example.securities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecConfig {



    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user=User.withUsername("user").password(passwordEncoder().encode("1234")).roles("USER").build();
        UserDetails admin=User.withUsername("admin").password(passwordEncoder().encode("1234")).roles("ADMIN").build();
// Here we make the user and store in the memory level understand
       return new InMemoryUserDetailsManager(user,admin);
    }
//    to provide the secuity encoder we use it

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }


}
