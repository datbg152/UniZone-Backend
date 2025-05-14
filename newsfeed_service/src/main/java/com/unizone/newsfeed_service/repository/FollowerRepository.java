package com.unizone.newsfeed_service.repository;

import com.unizone.newsfeed_service.entity.Follower;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FollowerRepository extends MongoRepository<Follower, String> {
    // Find follower by studentId
    //Follower findById(String id)
    // Find follower by studentId (returns Optional to handle missing data)
    //Optional<Follower> findById(String studentId);

}