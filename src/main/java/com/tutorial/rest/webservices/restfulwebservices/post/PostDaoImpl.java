package com.tutorial.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tutorial.rest.webservices.restfulwebservices.user.UserNotFoundException;

@Component
public class PostDaoImpl implements PostDao {

    private static List<Post> posts = new ArrayList<>(); 
    private static int counter = 4; 
    
    static {
        posts.add(new Post(1, 1, "trip to Goa", "Nice time with family",true));
        posts.add(new Post(2, 1, "trip to Malaysia", "Nice time with family",true));
        posts.add(new Post(3, 2, "trip to LA", "Nice time with family",true));
        posts.add(new Post(4, 3, "trip to NY", "Nice time with family",true));
        
    }
    
    @Override
    public Post findPost(int postId) {
        for(Post post: posts) {
            if(post.getId() == postId) {
                return post;
            }
        }
        throw new PostNotFoundException("Post Id: " + postId + " is not found");
    }

    @Override
    public List<Post> findAllPostsByUserId(int userId) {
        List<Post> returnPosts = new ArrayList<>();
        
        for(Post post: posts) {
            if(post.getUserId() == userId) {
                returnPosts.add(post);
            }
        }
        if(returnPosts.isEmpty()) {
            throw new PostNotFoundException("Posts for  UserId: " + userId + " are not found");
        }
        
        return returnPosts;
    }

    @Override
    public Post savePost(Post post) {
        if(post.getId() == 0) {
            post.setId(++counter);
        }
        posts.add(post);
        
        return post;
    }

    @Override
    public Post removePost(int postId) {
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()) {
            Post post = iterator.next();
            if(post.getId() == postId) {
                iterator.remove();
                return post;
            }
        }
        throw new PostNotFoundException("postId " + postId + " is not foud");
    }

    @Override
    public List<Post> removeAllPostsByUserId(int userId) {
        List<Post> allPosts = findAllPostsByUserId(userId);
        
        if(allPosts == null) {
            throw new UserNotFoundException("userId " + userId + " is not foud");
        }
        
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()) {
            for(Post removePost : allPosts) {
                if(removePost.getId() == iterator.next().getId()) {
                    iterator.remove();
                }
            }
        }
            
        return posts;
    }

}
