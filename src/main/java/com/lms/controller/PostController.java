package com.lms.controller;

import com.lms.entity.Post;
import com.lms.repository.CommentRepository;
import com.lms.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;


    }
     @PostMapping
    public String createPost(
            @RequestBody Post post
     ){
        postRepository.save(post);
        return "Post saved successfully";
    }
    @DeleteMapping
    public void deletePost(){
        postRepository.deleteById(1L);
    }
}
