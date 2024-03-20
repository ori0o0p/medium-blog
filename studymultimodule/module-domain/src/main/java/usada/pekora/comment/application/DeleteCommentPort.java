package usada.pekora.comment.application;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import usada.pekora.comment.model.Comment;

public interface DeleteCommentPort {
    Mono<Void> delete(Comment comment);
    Mono<Void> deleteById(String id);
    Flux<Void> deleteAllByArticleId(String articleId);

}
