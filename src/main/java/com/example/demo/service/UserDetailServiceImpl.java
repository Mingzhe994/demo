package com.example.demo.service;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * Created by Stuart on 26/9/17.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        MyUser myUser = userRepository.findByUsername(username);
        if(myUser == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(myUser.getUsername(), myUser.getPassword(),emptyList());
    }
}
