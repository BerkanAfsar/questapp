package com.project.questapp.repository;


import com.project.questapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

    //List<Post> findByUserId(Long userId);
}
