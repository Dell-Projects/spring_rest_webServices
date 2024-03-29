package com.spring.rest.webservices.restwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    //GET methods
    @GetMapping(value = "/jpa/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUserById(@PathVariable int id){

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id not found: " + id);

        return user;
    }

    //POST method
    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User newUser){

        //Create response that says in the POST response where the user has been created
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        User savedUser = userRepository.save(newUser);

        return ResponseEntity.created(location).build();
    }

    //DELETE method
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
}
