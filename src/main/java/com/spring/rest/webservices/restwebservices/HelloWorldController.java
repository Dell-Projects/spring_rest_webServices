package com.spring.rest.webservices.restwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Handle with HTTP requests and REST requests
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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
    @GetMapping("/helloWorld/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello, " + name);
    }

    //Map returning internationalized
    @GetMapping("/helloWorld-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
