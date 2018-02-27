package com.tutorial.restfulwebservices.test;

import java.util.Locale;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @Autowired
    MessageSource bundleMessageSource;
    
    private static final String HEADER_ACCEPT_LANGUAGE = "accept-language";

    @GetMapping(value="/test-message")
    public String testMessage() {
        return bundleMessageSource.getMessage("message.test", null, new Locale(MDC.get(HEADER_ACCEPT_LANGUAGE).toString()));
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