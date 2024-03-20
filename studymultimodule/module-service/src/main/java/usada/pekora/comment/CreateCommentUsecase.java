package usada.pekora.comment;

import reactor.core.publisher.Mono;
import usada.pekora.comment.model.dto.CreateCommentRequest;

public interface CreateCommentUsecase {
    Mono<Void> create(String articleId, CreateCommentRequest request);

}
