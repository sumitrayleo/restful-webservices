package com.tutorial.rest.webservices.restfulwebservices.test;

public class TestMessageBean {

    private String message;

    public TestMessageBean(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestMessageBean [message=" + message + "]";
    }
    
    
}
