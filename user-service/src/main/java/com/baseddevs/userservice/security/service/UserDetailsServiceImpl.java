package com.baseddevs.userservice.security.service;

import com.baseddevs.userservice.exception.UserNotFoundException;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.repository.UserRepository;
import com.baseddevs.userservice.security.model.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found with username: " + username)
        );
        return new SecurityUser(user);
    }
}
