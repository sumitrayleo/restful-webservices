package com.tutorial.restfulwebservices.post;

public class Post {
    
    private int id;
    private int userId;
    private String header;
    private String body;
    private Boolean active;
    
    public Post() {
    }

    public Post(int id, int userId, String header, String body, Boolean active) {
        super();
        this.id = id;
        this.userId = userId;
        this.header = header;
        this.body = body;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
}
