package com.unizone.newsfeed_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data  // Lombok annotation to generate getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Lombok annotation to generate a no-args constructor
@AllArgsConstructor  // Lombok annotation to generate an all-args constructor
@Document(collection = "posts")  // This maps to the 'posts' collection in MongoDB
public class Post {

    @Id
    private int id;  // Unique identifier for the post
    private String studentId;  // ID of the user who created the post
    private String content;  // The content of the post (e.g., text)
    private String createdAt;  // The timestamp when the post was created
    private int likes;  // Number of likes on the post
    private List<String> comments;  // List of comments (optional, can be further expanded to another object)
    private List<String> shares;  // List of users who shared the post (optional)
}