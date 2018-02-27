package com.tutorial.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserServiceCommandLine implements CommandLineRunner{

    private final static Logger log = LoggerFactory.getLogger(UserServiceCommandLine.class);
    
    @Autowired
    private UserService userService;
    
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("Jack", new Date()));
        users.add(new User("Jill", new Date()));
        users.add(new User("Marry", new Date()));
    }
    
    @Override
    public void run(String... args) throws Exception {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            userService.saveUser(iterator.next());
        }
        log.info("Here are all the users created :" + userService.findAllUsers());
    }

}
