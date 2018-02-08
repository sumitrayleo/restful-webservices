package com.tutorial.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
    
    private int id;
    private String name;
    private Date dateOfBirth;
    
    public User() {
    }
    
    public User(int id, String name, Date dateOfBirth) {
        super();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", getId()=" + getId() + ", getName()="
                        + getName() + ", getDateOfBirth()=" + getDateOfBirth() + ", getClass()=" + getClass() + ", hashCode()="
                        + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
    
}
