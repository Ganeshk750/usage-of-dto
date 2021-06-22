package com.example.controller;


import com.example.dto.PostDto;
import com.example.model.Post;
import com.example.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @created: 22/06/2021 - 2:18 PM
 * @author: Ganesh
 */

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final ModelMapper modelMapper;
    private final PostService postService;


    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id){
        Post post  = postService.getPostById(id);

        // Converting Model to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return new ResponseEntity<PostDto>(postResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){

        //Convert Dto To Model
        Post postRequest = modelMapper.map(postDto, Post.class);

        Post post = postService.createPost(postRequest);

        // Convert Model to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);

    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) {

        // convert DTO to Entity
        Post postRequest = modelMapper.map(postDto, Post.class);

        Post post = postService.updatePost(id, postRequest);

        // entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return ResponseEntity.ok().body(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePost(id);
       // ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        String apiResponse = "Post deleted successfully";
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}


