package usada.pekora.article;

import reactor.core.publisher.Mono;
import usada.pekora.article.model.dto.CreateArticleRequest;

public interface CreateArticleUsecase {
    Mono<Void> create(CreateArticleRequest request);

}
