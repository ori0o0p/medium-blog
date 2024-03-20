package usada.pekora.comment;

import reactor.core.publisher.Mono;

public interface DeleteCommentUsecase {
    Mono<Void> deleteById(String commentId);

}
