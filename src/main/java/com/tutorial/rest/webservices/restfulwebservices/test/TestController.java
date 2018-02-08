package com.tutorial.rest.webservices.restfulwebservices.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value="/test-message")
    public String testMessage() {
        return "Hello Friends";
    }
    
    @GetMapping(value="/test-message-bean")
    public TestMessageBean testMessageBean() {
        return new TestMessageBean("Hello World Friends");
    }
    
    @GetMapping(value="/test-message/path-variable/{name}")
    public TestMessageBean testMessagePathVariable(@PathVariable String name) {
        return new TestMessageBean(String.format("Hello, %s", name));
    }
}