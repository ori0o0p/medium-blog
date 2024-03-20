package usada.pekora.article;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import usada.pekora.article.model.Article;

public interface GetArticleUsecase {
    Flux<Article> findAll();

}
