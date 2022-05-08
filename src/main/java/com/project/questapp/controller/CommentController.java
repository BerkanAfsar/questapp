package com.project.questapp.controller;

import com.project.questapp.entity.Comment;
import com.project.questapp.request.CommentCreateRequest;
import com.project.questapp.request.CommentUpdateRequest;
import com.project.questapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getComments(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }

    public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createComment(commentCreateRequest);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateCommentById(commentId, commentUpdateRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }
}
