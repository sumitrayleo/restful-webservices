package com.tutorial.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    // findAllUsers
    @GetMapping(value = "/users")
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    // addNewUsers
    @PostMapping(value = "/users")
    public ResponseEntity<User> addNewUser(@Valid @RequestBody User user) {
        User savedUser = userDao.saveUser(user);

        URI restUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(restUri).build();
    }

    // findUser 
    @GetMapping(value = "/users/{id}")
    public User findUser(@PathVariable int id) {
        return userDao.findUser(id);
    }
    
    @DeleteMapping(value = "/users/{id}")
    public User removeUser(@PathVariable int id) {
        return userDao.removeUser(id);
    }
}
