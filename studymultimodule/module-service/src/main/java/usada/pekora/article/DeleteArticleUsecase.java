package usada.pekora.article;

import reactor.core.publisher.Mono;

public interface DeleteArticleUsecase {
    Mono<Void> deleteById(String articleId);

}
