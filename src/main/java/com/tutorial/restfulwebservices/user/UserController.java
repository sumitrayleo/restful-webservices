package com.tutorial.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
    
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    // findAllUsers
    @GetMapping(value = "/users")
    public List<User> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        log.info("The retrieved users are : " + userList);
        return userList;
    }

    // addNewUsers
    @PostMapping(value = "/users")
    public ResponseEntity<User> addNewUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);

        URI restUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(restUri).build();
    }

    // findUser 
    @GetMapping(value = "/users/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findUser(id);
    }
    
    @DeleteMapping(value = "/users/{id}")
    public User removeUser(@PathVariable int id) {
        return userService.removeUser(id);
    }
}
