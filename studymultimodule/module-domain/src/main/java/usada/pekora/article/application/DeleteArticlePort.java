package usada.pekora.article.application;

import reactor.core.publisher.Mono;
import usada.pekora.article.model.Article;

public interface DeleteArticlePort {
    Mono<Void> delete(Article article);
    Mono<Void> deleteById(String id);

}
