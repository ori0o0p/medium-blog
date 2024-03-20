package usada.pekora.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import usada.pekora.article.CreateArticleUsecase;
import usada.pekora.article.application.SaveArticlePort;
import usada.pekora.article.model.Article;
import usada.pekora.article.model.dto.CreateArticleRequest;

@Service
@RequiredArgsConstructor
public class CreateArticleService implements CreateArticleUsecase {
    private final SaveArticlePort saveArticlePort;

    @Override
    public Mono<Void> create(CreateArticleRequest request) {
        return saveArticlePort.save(Article.builder()
                .title(request.title())
                .content(request.content())
                .build())
                .then();
    }

}
