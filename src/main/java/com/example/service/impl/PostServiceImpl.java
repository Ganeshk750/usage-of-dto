package com.example.service.impl;


import com.example.exception.ResourseNotFoundException;
import com.example.model.Post;
import com.example.repository.PostRepository;
import com.example.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @created: 22/06/2021 - 1:54 PM
 * @author: Ganesh
 */


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(long id, Post postR) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Post", "id", id));
        post.setTitle(postR.getTitle());
        post.setDescription(postR.getDescription());
        post.setContent(postR.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
      Post post = postRepository.findById(id)
              .orElseThrow(() -> new ResourseNotFoundException("Post", "id", id));
           postRepository.delete(post);
    }

    @Override
    public Post getPostById(long id) {
        Optional<Post> postt = postRepository.findById(id);
        if(postt.isPresent()){
            return postt.get();
        }else{
            throw new ResourseNotFoundException("Post", "id", id);
        }

      //  Post post = postRepository.findById(id)
   		//		.orElseThrow(() -> new ResourseNotFoundException("Post", "id", id));
        //return post;
    }

}
