package com.sahin.springsecurityjwt2.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles = null;

        if (username.equals("admin")) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User("admin", "$2y$12$A9xiZYaBB5P99RCBkI.8Mer.bfiEy355qw1sXSIWVFGW0NyOUjt8O", roles);
        }
        if (username.equals("user")) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User("user", "$2y$12$E8ato0JDIjdwpXd864KsQei1PRshFqMQKxypqX/tK9PKy5yfBXNNa", roles);
        }

        throw new UsernameNotFoundException("User not found with name :" + username);
    }
}
