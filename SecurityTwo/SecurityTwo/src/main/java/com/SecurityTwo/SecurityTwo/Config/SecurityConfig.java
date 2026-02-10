package com.SecurityTwo.SecurityTwo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


//    from Here it will load the User
//@Bean
//public UserDetailsService getDetailsService(){
//        return new CustomUserDetailsService();
//}


//SecurtyFilterchain
// this secuirty fileter is from our another default login page
//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
//      http.authorizeHttpRequests(auth->auth.requestMatchers(
//"/"
//      ).permitAll().anyRequest().authenticated()
//      ).formLogin(form->form.defaultSuccessUrl("/", true)
//      ).
//              logout(logout->logout.permitAll());
//      return http.build();
//    }



//this secuirty fileter is for our custom login page
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth->auth.requestMatchers(
                                "/"
                        ).permitAll().anyRequest().authenticated()
                ).formLogin(form->form.loginPage("/sign").defaultSuccessUrl("/home",true).permitAll()
                ).logout(logout->logout.permitAll());
        return http.build();
    }












//
//
//
//    Provider
//    doa authenticationProvider will take two things first the object of the UserDetails (implemented class ) and the second one is passwordEncoder
//  in the video using the old version and i am using the new versionso that why it is not necessary
// DaoAuthenticationProvider is the actual authentication engine  it connects UserDetailsService,PasswordEncode and spring needt components that is  DaoAuthenticationProvider



//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(getDetailsService());
//        daoAuthenticationProvider.setPasswordencoder(passwordEncoder());
//        return daoAuthenticationProvider;
//
//
//    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            CustomUserDetailsService userDetailsService,
            BCryptPasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }



}
