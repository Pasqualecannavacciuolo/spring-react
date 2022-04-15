package com.corso.java.corsojava.controller;

import com.corso.java.corsojava.domain.User;
import com.corso.java.corsojava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "/api/v1")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path="/{id}")
    ResponseEntity<User> findById(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);
        return new ResponseEntity<User>((User) userRepository.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping(path="/")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
