package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repositories.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService{

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getPosts(Optional<Long> userId) {

//        if(userId.isPresent())
//            return postRepository.findByUserId(userId.get());

        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createPost(PostCreateRequest postRequest){

        User user = userService.getUserById(postRequest.getUserId());

        if(user == null)
            return null;

        Post post = new Post();
        post.setId(postRequest.getId());
        post.setText(postRequest.getText());
        post.setTitle(postRequest.getTitle());
        post.setUser(user);

        return postRepository.save(post);
    }

    public Post updatePost(Long postId, PostUpdateRequest postUpdateRequest){

        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()){

            Post existingPost = post.get();

            existingPost.setText(postUpdateRequest.getText());
            existingPost.setTitle(postUpdateRequest.getTitle());

            postRepository.save(existingPost);

            return existingPost;
        }
        else
            return null;
    }

    public void deletePostById(Long postId){
        postRepository.deleteById(postId);
    }
}
