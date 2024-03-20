package usada.pekora.comment.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import usada.pekora.comment.model.Comment;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
    Flux<Void> deleteAllByArticle_Id(String articleId);

}
