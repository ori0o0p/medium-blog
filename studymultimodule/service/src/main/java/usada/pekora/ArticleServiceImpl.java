package usada.pekora;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Mono<Void> create(CreateArticleRequest request) {
        return articleRepository.save(Article.builder().title(request.title()).content(request.content()).build()).then();
    }

    @Override
    public Flux<Article> findAll() {
        return articleRepository.findAll();
    }
}
