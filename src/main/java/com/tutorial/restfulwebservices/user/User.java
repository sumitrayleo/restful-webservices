package com.tutorial.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This API contains details of the user")
public class User {
    
    private int id;
    @Size(min = 2, message = "Name should be at least of 2 characters")
    @ApiModelProperty(notes = "Name should be at least of 2 characters")
    private String name;
    @Past(message = "Date Of Birth should be a past date")
    @ApiModelProperty(notes = "Date Of Birth should be a past date")
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
