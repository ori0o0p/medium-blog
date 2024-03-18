package usada.pekora;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArticleService {

    Mono<Void> create(CreateArticleRequest request);

    Flux<Article> findAll();
}
