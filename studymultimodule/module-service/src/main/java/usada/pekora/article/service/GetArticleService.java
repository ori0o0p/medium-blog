package usada.pekora.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import usada.pekora.article.GetArticleUsecase;
import usada.pekora.article.application.GetArticlePort;
import usada.pekora.article.model.Article;

@Service
@RequiredArgsConstructor
public class GetArticleService implements GetArticleUsecase {
    private final GetArticlePort getArticlePort;

    @Override
    public Flux<Article> findAll() {
        return getArticlePort.findAll();
    }

}
