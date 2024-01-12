package com.example.mediumspringwebflux.domain.comment.repository;

import com.example.mediumspringwebflux.domain.comment.document.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
}
