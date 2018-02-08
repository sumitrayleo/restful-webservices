package com.tutorial.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{

    private static List<User> users = new ArrayList<>(); 
    private static int counter = 3; 
    
    static {
        users.add(new User(1, "Jiya", new Date()));
        users.add(new User(2, "Paul", new Date()));
        users.add(new User(3, "Demi", new Date()));
    }
    
    @Override
    public List<User> findAllUsers() {
        return users;
    }
    
    @Override
    public User saveUser(User user) {
        if(user.getId() == 0) {
            user.setId(++counter);
        }
        users.add(user);
        
        return user;
    }
    
    @Override
    public User findUser(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("id: " + id + " is not found");

    }

    @Override
    public User removeUser(int id) {
        Iterator<User> iterator = users.iterator();
        
        while(iterator.hasNext()) {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        throw new UserNotFoundException("id: " + id + " is not found");        
    }
}
