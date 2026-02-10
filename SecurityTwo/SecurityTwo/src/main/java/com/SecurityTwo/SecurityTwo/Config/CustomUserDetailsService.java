package com.SecurityTwo.SecurityTwo.Config;

import com.SecurityTwo.SecurityTwo.Entity.Employee;
import com.SecurityTwo.SecurityTwo.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@EnableMethodSecurity(prePostEnabled = true)
public class CustomUserDetailsService implements UserDetailsService {


@Autowired
    private EmpRepo empoRepo;
//    laodByUserName are used to laod the user from the database
    @Override
    public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
        // after finding the User in the database  it will return the User
      Employee emp  = empoRepo.findByEmail(email);

      if(emp== null){
          throw new UsernameNotFoundException("User name not found ");
      }
      else {
//           Here UserDetails are the inteface se we return the implemetation class of it
          return new CustomUser(emp);
      }

    }
}
