package com.tutorial.restfulwebservices.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Post p WHERE p.user.id = :userId")
    public void deleteAllPostByUserId(@Param("userId") int userId);

}
