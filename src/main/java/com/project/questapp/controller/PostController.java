package com.project.questapp.controller;

import com.project.questapp.entity.Post;
import com.project.questapp.request.PostCreateRequest;
import com.project.questapp.request.PostUpdateRequest;
import com.project.questapp.service.PostService;
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
    public Post createPost(@RequestBody PostCreateRequest postrequest){
        return  postService.createPost(postrequest);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updatePost(postId, postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){
        postService.deletePostById(postId);
    }
}
