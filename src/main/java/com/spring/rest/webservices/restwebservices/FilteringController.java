package com.spring.rest.webservices.restwebservices;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class FilteringController {

    //Show field 1 and field 2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("Value 1", "Value 2", "Value 3");

        //Map that will be used to filter the values
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        //Creating filters to use in the map
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }

    //Show field 2 and field 3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveBeanList(){

        List<SomeBean> list = Arrays.asList(
                new SomeBean("Value1 a", "Value1 b", "Value1 c"),
                new SomeBean("Value2 a", "Value2 b", "Value2 c"));

        //Map that will be used to filter the values
        MappingJacksonValue mapping = new MappingJacksonValue(list);

        //Creating filters to use in the map
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
}
