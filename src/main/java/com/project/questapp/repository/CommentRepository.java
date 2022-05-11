package com.project.questapp.repository;

import com.project.questapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

//    List<Comment> findByUserIdAndPostId(Long userId, Long postId);
//
//    List<Comment> findByUserId(Long userId);
//
//    List<Comment> findByPostId(Long postId);
}
