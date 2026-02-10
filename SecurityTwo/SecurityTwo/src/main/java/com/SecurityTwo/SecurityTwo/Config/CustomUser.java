package com.SecurityTwo.SecurityTwo.Config;

import com.SecurityTwo.SecurityTwo.Entity.Employee;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUser  implements UserDetails {


    private Employee emp;

    CustomUser(Employee emp){
        this.emp=emp;
    }

/*
It is a interface
* GrantedAutority method are used to proivde the authorization and authentication to the user like Role_USER , ROLE _ADMIN,
and the SimpleGrandAuthority is the implementaiton class of the GrantedAuthority
* */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        this simpleGrantedAuthority need a string
        SimpleGrantedAuthority authority= new SimpleGrantedAuthority(emp.getRole());

        return Arrays.asList(authority);
    }

    @Override
    public  String getPassword() {
        return  emp.getPassword();
    }

    @Override
    public String getUsername() {
//        this userName are used in the CustomUserDetailsService
        return emp.getEmail();
    }


//    In this we can just focuso on normal and do not focus on it
    @Override
    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
        return true;
    }
}
