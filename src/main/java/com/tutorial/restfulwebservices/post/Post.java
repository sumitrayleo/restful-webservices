package com.tutorial.restfulwebservices.post;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutorial.restfulwebservices.user.User;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="post")
@ApiModel(value="Posts for particular users")
public class Post {
    
    @Id
    @GeneratedValue
    private int id;
    private String description;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JsonIgnore
    private User user;
    
    public Post() {
    }

    public Post(String description, User user) {
        super();
        this.description = description;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + description + "]";
    }

}
