package com.tutorial.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public List<User> findAllUsers() {
        return userDAOService.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userDAOService.save(user);
    }

    @Override
    public User findUser(int id) {
        if (userDAOService.exists(id)) {
            return userDAOService.findOne(id);
        }
        throw new UserNotFoundException("id: " + id + " is not found");

    }

    @Override
    public List<User> removeUser(int id) {
        
        if (userDAOService.exists(id)) {
            userDAOService.delete(id);
            return userDAOService.findAll();
        }
        throw new UserNotFoundException("id: " + id + " is not found");
    }
}
