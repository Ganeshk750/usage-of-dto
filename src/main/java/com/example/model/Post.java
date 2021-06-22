package com.example.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @created: 22/06/2021 - 1:45 PM
 * @author: Ganesh
 */


@NoArgsConstructor
@Data
@Table(name="posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="content")
    private String content;


}
