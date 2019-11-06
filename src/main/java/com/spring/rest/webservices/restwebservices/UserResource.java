package com.spring.rest.webservices.restwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return userDAOService.findById(id);
    }

    //POST methods

}
