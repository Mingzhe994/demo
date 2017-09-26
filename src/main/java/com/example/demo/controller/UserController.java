package com.example.demo.controller;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Stuart on 22/9/17.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody MyUser myUser){

        myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
        userRepository.save(myUser);
    }

    @GetMapping("/detail={id}")
    public Object findById(@PathVariable String id){
        return userRepository.findById(id);
    }

    @GetMapping("{username}")
    public Object findByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

}
