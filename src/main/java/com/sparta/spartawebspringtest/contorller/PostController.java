package com.sparta.spartawebspringtest.contorller;


import com.sparta.spartawebspringtest.dto.MessageDto;
import com.sparta.spartawebspringtest.dto.PostDto;
import com.sparta.spartawebspringtest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping("/post")
    public PostDto.Response createPost(@RequestBody PostDto.Request dto) {
        return postService.createPost(dto);
    }

    @GetMapping("/post")
    public List<PostDto.Response> getPosts() {
        return postService.getPosts();
    }

    @PutMapping("/post/{id}")
    public PostDto.Response updatePost(@PathVariable Long id, @RequestBody PostDto.Request dto) {
        return postService.updatePost(id, dto);
    }

    @DeleteMapping("/post/{id}")
    public MessageDto.Response deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
