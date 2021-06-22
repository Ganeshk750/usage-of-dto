package com.example.repository;


import com.example.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @created: 22/06/2021 - 1:55 PM
 * @author: Ganesh
 */


public interface PostRepository extends JpaRepository<Post, Long> {
}
