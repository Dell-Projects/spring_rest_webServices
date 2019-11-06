package com.spring.rest.webservices.restwebservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Handle with HTTP requests and REST requests
@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    public String helloWorld(){
        return "Hello World!";
    }
}
