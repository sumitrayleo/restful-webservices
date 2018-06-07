package com.tutorial.restfulwebservices.post;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorial.restfulwebservices.user.User;
import com.tutorial.restfulwebservices.user.UserNotFoundException;
import com.tutorial.restfulwebservices.user.UserRepository;

@RestController
public class PostController {
    
    @Autowired
    protected PostRepository postRepository;
    
    @Autowired
    protected UserRepository userRepository;
    
    @GetMapping(value = "/users/{userId}/posts")
    public List<Post> findAllPostsByUserId(@PathVariable final int userId){
        
        final Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("id: " + userId + " is not found");
        }
        
        return optionalUser.get().getPosts();
    }
    
    @PostMapping(value = "/users/{userId}/posts")
    public ResponseEntity<Post> savePosts(@PathVariable final int userId, @RequestBody Post post){
        final Optional<User> optionalUser = userRepository.findById(userId);
        
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("id: " + userId + " is not found");
        }
        
        post.setUser(optionalUser.get());
        postRepository.save(post);
        
        URI restUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(restUri).build();
        
    }
    
    
    @DeleteMapping(value = "/users/{userId}/posts/{postId}")
    public void removeAllPostByUserId(@PathVariable final int userId, @PathVariable final int postId) {
        
        postRepository.deleteById(postId);
    }
    
    @DeleteMapping(value = "/users/{userId}/posts")
    public void removeAllPostByUserId(@PathVariable final int userId) {
        
        postRepository.deleteAllPostByUserId(userId);
    }
    
    
}
