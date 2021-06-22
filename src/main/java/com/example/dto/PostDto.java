package com.example.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * @created: 22/06/2021 - 1:50 PM
 * @author: Ganesh
 */


@Data
public class PostDto implements Serializable {

    private long id;
    private String title;
    private String description;
    private String content;
}
