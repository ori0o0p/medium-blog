package usada.pekora;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import usada.pekora.article.CreateArticleUsecase;
import usada.pekora.article.DeleteArticleUsecase;
import usada.pekora.article.GetArticleUsecase;
import usada.pekora.article.model.Article;
import usada.pekora.article.model.dto.CreateArticleRequest;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final CreateArticleUsecase createArticleUsecase;
    private final GetArticleUsecase getArticleUsecase;
    private final DeleteArticleUsecase deleteArticleUsecase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody CreateArticleRequest request) {
        return createArticleUsecase.create(request);
    }

    @GetMapping
    public Flux<Article> findAll() {
        return getArticleUsecase.findAll();
    }

    @DeleteMapping("/{articleId}")
    public Mono<Void> delete(@PathVariable String articleId) {
        return deleteArticleUsecase.deleteById(articleId);
    }

}
