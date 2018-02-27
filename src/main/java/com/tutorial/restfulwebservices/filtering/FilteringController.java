package com.tutorial.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping(value = "/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean bean = new SomeBean("value1", "value2", "value3");

        Set<String> filteringset = new HashSet<>();
        filteringset.add("field1");
        filteringset.add("field2");
        MappingJacksonValue mapping = dynamicFiltering(bean, filteringset);

        return mapping;
    }

    @GetMapping(value = "/filtering-list")
    public MappingJacksonValue retrieveSomeBeanList() {
        List<SomeBean> someBeanList =
            Arrays.asList(new SomeBean("value12", "value22", "value32"), new SomeBean("value11", "value21", "value31"));

        Set<String> filteringset = new HashSet<>();
        filteringset.add("field3");
        filteringset.add("field2");
        MappingJacksonValue mapping = dynamicFiltering(someBeanList, filteringset);
        
        return mapping;
    }
    
    private MappingJacksonValue dynamicFiltering(Object object, Set<String> filteringset) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filteringset);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(object);
        mapping.setFilters(filterProvider);
        return mapping;
    }
}
