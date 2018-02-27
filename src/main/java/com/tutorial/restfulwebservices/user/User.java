package com.tutorial.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "User")
@ApiModel(description = "This API contains details of the user")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 2, message = "Name should be at least of 2 characters")
    @ApiModelProperty(notes = "Name should be at least of 2 characters")
    private String name;
    @Past(message = "Date Of Birth should be a past date")
    @ApiModelProperty(notes = "Date Of Birth should be a past date")
    private Date dateOfBirth;

    public User() {
    }

    public User(String name, Date dateOfBirth) {
        super();
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
        return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
    }

}
