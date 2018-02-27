package com.tutorial.restfulwebservices.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostController {
    
    @Autowired
    protected PostDao postDao;
    
    @GetMapping(value = "/users/post/{postId}")
    public Post findPostById(@PathVariable final int postId) {
        return postDao.findPost(postId);
    }
    
    @GetMapping(value = "/users/all-post/{userId}")
    public List<Post> findAllPostsByUserId(@PathVariable final int userId){
        return postDao.findAllPostsByUserId(userId);
    }
    
    @PostMapping(value = "/users/post")
    public ResponseEntity<Post> savePosts(@RequestBody final Post post){
        postDao.savePost(post);
        
        URI restUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(restUri).build();
        
    }
    
    @DeleteMapping(value = "/users/post/{postId}")
    public Post removePostById(@PathVariable final int postId) {
        return postDao.removePost(postId);
    }
    
    @DeleteMapping(value = "/users/all-post/{userId}")
    public List<Post> removeAllPostsByUserId(@PathVariable final int userId) {
        return postDao.removeAllPostsByUserId(userId);
    }
    
}
