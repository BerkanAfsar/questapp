package com.project.questapp.service;

import com.project.questapp.entity.Comment;
import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;
import com.project.questapp.repository.CommentRepository;
import com.project.questapp.request.CommentCreateRequest;
import com.project.questapp.request.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getComments(Optional<Long> userId, Optional<Long> postId){

//        if(userId.isPresent()){
//
//            return commentRepository.findByUserId(userId.get());
//        }
//        else if(postId.isPresent()){
//            return commentRepository.findByPostId(postId.get());
//        }
//        else if(postId.isPresent() && userId.isPresent()){
//
//            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
//        }
//        else
            return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId){
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CommentCreateRequest commentCreateRequest){

        User user = userService.getUserById(commentCreateRequest.getUserId());

        Post post = postService.getPostById(commentCreateRequest.getPostId());

        if(user != null && post != null){
            Comment comment = new Comment();

            comment.setId(commentCreateRequest.getId());
            comment.setText(commentCreateRequest.getText());
            comment.setTitle(commentCreateRequest.getTitle());
            comment.setUser(user);
            comment.setPost(post);

            return commentRepository.save(comment);
        }
        else
            return null;
    }

    public Comment updateCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest){

        Optional<Comment> comment = commentRepository.findById(commentId);

        if(comment.isPresent()){

            Comment commentToUpdate = comment.get();

            commentToUpdate.setText(commentUpdateRequest.getText());

            return commentRepository.save(commentToUpdate);
        }
        else
            return null;
    }

    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
