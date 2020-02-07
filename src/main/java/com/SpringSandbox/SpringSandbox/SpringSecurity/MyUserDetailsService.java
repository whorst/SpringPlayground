package com.SpringSandbox.SpringSandbox.SpringSecurity;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    //Meant to get a UserDetails object from your repository

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        //Stop at 33:00 in the video
        return user.map(MyUserDetails::new).get();
    }

}
