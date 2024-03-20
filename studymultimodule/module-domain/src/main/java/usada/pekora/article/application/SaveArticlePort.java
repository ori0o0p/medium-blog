package usada.pekora.article.application;

import reactor.core.publisher.Mono;
import usada.pekora.article.model.Article;

public interface SaveArticlePort {
    Mono<Article> save(Article article);

}
