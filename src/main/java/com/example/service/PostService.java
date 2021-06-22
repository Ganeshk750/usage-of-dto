package com.example.service;


import com.example.model.Post;

import java.util.List;

/**
 * @created: 22/06/2021 - 1:52 PM
 * @author: Ganesh
 */


public interface PostService {
    List<Post> getAllPosts();
    Post createPost(Post post);
    Post updatePost(long id, Post post);
    void deletePost(long id);
    Post getPostById(long id);
}
