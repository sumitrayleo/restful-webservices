package com.tutorial.restfulwebservices.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class AppendLinksToResponse {

    public void addLinksToResponse(Object object, String methodName){
        //Resource<T> resource = new Resource<>(object);
        ControllerLinkBuilder builder = linkTo(methodName);
    }
}
