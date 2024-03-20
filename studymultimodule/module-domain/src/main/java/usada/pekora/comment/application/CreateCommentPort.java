package usada.pekora.comment.application;

import reactor.core.publisher.Mono;
import usada.pekora.comment.model.Comment;

public interface CreateCommentPort {
    Mono<Comment> create(Comment comment);

}
