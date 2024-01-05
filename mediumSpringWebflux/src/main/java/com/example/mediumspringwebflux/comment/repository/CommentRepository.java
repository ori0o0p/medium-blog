package com.example.mediumspringwebflux.comment.repository;

import com.example.mediumspringwebflux.comment.document.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
}
