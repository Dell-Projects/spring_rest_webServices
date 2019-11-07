package com.spring.rest.webservices.restwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("Value 1", "Value 2", "Value 3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveBeanList(){
        return Arrays.asList(
                new SomeBean("Value1 a", "Value1 b", "Value1 c"),
                new SomeBean("Value2 a", "Value2 b", "Value2 c"));
    }
}
