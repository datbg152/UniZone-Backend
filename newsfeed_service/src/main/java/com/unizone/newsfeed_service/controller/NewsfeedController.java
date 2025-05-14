package com.unizone.newsfeed_service.controller;

import com.unizone.newsfeed_service.entity.Post;
import com.unizone.newsfeed_service.service.AuthServiceClient;
import com.unizone.newsfeed_service.service.NewsfeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newsfeed")
public class NewsfeedController {

    private final AuthServiceClient authServiceClient;
    @Autowired
    private NewsfeedService newsfeedService;


    @Autowired
    public NewsfeedController(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @PostMapping("/getNewsFeed")
    public ResponseEntity<?> getNewsFeed(@RequestHeader("Authorization") String token) {
        // Extract studentId from the token via AuthServiceClient
        String studentId = authServiceClient.verifyToken(token.substring(7));  // Remove 'Bearer ' part

        if (studentId == null) {
            return ResponseEntity.status(401).body("Invalid Token");
        }

        // For now, just return the studentId as a placeholder (you can replace this with actual newsfeed logic later)
        return ResponseEntity.ok("User's newsfeed for studentId: " + studentId);
    }

    @GetMapping("/getPosts")
    public List<Post> getPosts(@RequestParam String studentId) {
        return newsfeedService.getFollowedUserPosts(studentId);
    }
}