package com.tutorial.restfulwebservices.user;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAOService extends JpaRepository<User, Serializable>{

}
