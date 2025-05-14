package com.unizone.newsfeed_service.repository;

import com.unizone.newsfeed_service.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByStudentIdIn(List<String> studentIds);
}