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
@Document(collection = "follows")  // This maps to the 'followers' collection in MongoDB
public class Follower {

    @Id
    private String id;  // Unique identifier for the follower relationship
    private List<String> following;  // List of user IDs that the student is following
}
