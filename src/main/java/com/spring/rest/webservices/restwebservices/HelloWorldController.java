package com.spring.rest.webservices.restwebservices;

import org.springframework.web.bind.annotation.*;

//Handle with HTTP requests and REST requests
@RestController
public class HelloWorldController {

    //Map returning string
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World!";
    }

    //Map returning a bean
    @GetMapping("/helloWorldBean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world! (w/ Bean)");
    }

    //Map returning a bean w/ a variable
    @GetMapping("/helloWorld/pathVariable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello, " + name);
    }
}
