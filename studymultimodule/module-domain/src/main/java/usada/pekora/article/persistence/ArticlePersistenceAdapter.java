package usada.pekora.article.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import usada.pekora.article.model.Article;
import usada.pekora.article.repository.ArticleRepository;
import usada.pekora.article.application.SaveArticlePort;
import usada.pekora.article.application.DeleteArticlePort;
import usada.pekora.article.application.GetArticlePort;

@Component
@RequiredArgsConstructor
public class ArticlePersistenceAdapter implements SaveArticlePort, DeleteArticlePort, GetArticlePort {
    private final ArticleRepository articleRepository;

    @Override
    public Mono<Article> save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Mono<Void> delete(Article article) {
        return articleRepository.delete(article);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return articleRepository.deleteById(id);
    }

    @Override
    public Mono<Article> findById(String id) {
        return articleRepository.findById(id);
    }

    @Override
    public Flux<Article> findAll() {
        return articleRepository.findAll();
    }

}
