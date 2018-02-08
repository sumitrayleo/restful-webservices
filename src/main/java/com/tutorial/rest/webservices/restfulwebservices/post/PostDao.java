package com.tutorial.rest.webservices.restfulwebservices.post;

import java.util.List;

public interface PostDao {
    
    // findPost
    public Post findPost(final int postId);
    
    // findAllPosts
    public List<Post> findAllPostsByUserId(final int userId);
    
    // addPost
    public Post savePost(final Post post);
    
    // deletePost
    public Post removePost(final int postId);
    
    // deletePost
    public List<Post> removeAllPostsByUserId(final int userId);

}
