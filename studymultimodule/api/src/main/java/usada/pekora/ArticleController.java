package usada.pekora;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public Mono<Void> create(@RequestBody CreateArticleRequest request) {
        return articleService.create(request);
    }

    @GetMapping
    public Flux<Article> findAll() {
        return articleService.findAll();
    }

}
