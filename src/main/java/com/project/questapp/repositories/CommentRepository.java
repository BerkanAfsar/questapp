package com.project.questapp.repositories;

import com.project.questapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

//    List<Comment> findByUserIdAndPostId(Long userId, Long postId);
//
//    List<Comment> findByUserId(Long userId);
//
//    List<Comment> findByPostId(Long postId);
}
