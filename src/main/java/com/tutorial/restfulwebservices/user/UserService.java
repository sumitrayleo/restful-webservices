package com.tutorial.restfulwebservices.user;

import java.util.List;

public interface UserService {
    
    public List<User> findAllUsers();
    
    public User saveUser(User user);
    
    public User findUser(int id);
    
    public List<User> removeUser(int id);

}
