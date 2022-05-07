package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam Optional<Long> userId){ //RequestParam requesti pars et ve buradaki değişkene at demek.Optional da userId gelirse buna göre getir yoksa hepsini getir. Yani yoksa /posts varsa /posts?userId={userId} olur endpoint

        return postService.getPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){ //PathVariable posts/{postId} urlindeki direk postId yi alıyor

        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return  postService.createPost(post);
    }
}
