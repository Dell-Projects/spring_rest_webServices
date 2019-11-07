package com.spring.rest.webservices.restwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDAOService userDAOService;

    //GET methods
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDAOService.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable int id){

        User user = userDAOService.findById(id);
        if(user == null)
            throw new UserNotFoundException("id not found: " + id);
        return user;
    }

    //POST method
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User newUser){

        //Create response that says in the POST response where the user has been created
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        User savedUser = userDAOService.save(newUser);

        return ResponseEntity.created(location).build();
    }

    //DELETE method
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id){
        User user = userDAOService.deleteById(id);
        if(user == null)
            throw new UserNotFoundException("id not found: " + id);
        return user;
    }
}
