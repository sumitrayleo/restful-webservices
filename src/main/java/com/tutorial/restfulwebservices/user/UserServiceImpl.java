package com.tutorial.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUser(int id) {
        if (userRepository.exists(id)) {
            return userRepository.findOne(id);
        }
        throw new UserNotFoundException("id: " + id + " is not found");

    }

    @Override
    public List<User> removeUser(int id) {
        
        if (userRepository.exists(id)) {
            userRepository.delete(id);
            return userRepository.findAll();
        }
        throw new UserNotFoundException("id: " + id + " is not found");
    }
}
