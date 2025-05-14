package com.unizone.newsfeed_service.service;

import com.unizone.newsfeed_service.entity.Follower;
import com.unizone.newsfeed_service.entity.Post;
import com.unizone.newsfeed_service.repository.PostRepository;
import com.unizone.newsfeed_service.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NewsfeedService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FollowerRepository followerRepository;

    public List<Post> getFollowedUserPosts(String studentId) {

        Optional<Follower> followerOpt = followerRepository.findById(studentId);
        System.out.println("FollowerOpt: " + followerOpt);

        if (followerOpt.isPresent()) {
            System.out.println("Follower found: " + followerOpt.get());
        } else {
            System.out.println("No follower found for studentId: " + studentId);
            return new ArrayList<>();
        }

        Follower follower = followerOpt.get();
        System.out.println("Follower found: " + follower);
        Set<String> followees = new HashSet<>(follower.getFollowing());
        followees.add(studentId);  // Include the user themselves

        System.out.println("Followees for studentId " + studentId + ": " + followees);

        // Fetch posts for all followed users
        List<Post> allPosts = postRepository.findByStudentIdIn(new ArrayList<>(followees));

        // Check if posts are retrieved correctly
        if (allPosts.isEmpty()) {
            System.out.println("No posts found for the followed users.");
        }

        // Sort posts by createdAt (most recent first)
        allPosts.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));

        return allPosts;  // Return the sorted list of posts
    }
}