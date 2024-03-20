package usada.pekora.article.application;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import usada.pekora.article.model.Article;

public interface GetArticlePort {
    Mono<Article> findById(String id);
    Flux<Article> findAll();

}
