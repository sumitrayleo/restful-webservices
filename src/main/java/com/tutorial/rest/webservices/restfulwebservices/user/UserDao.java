package com.tutorial.rest.webservices.restfulwebservices.user;

import java.util.List;

public interface UserDao {
    
    public List<User> findAllUsers();
    
    public User saveUser(User user);
    
    public User findUser(int id);
    
    public User removeUser(int id);

}
