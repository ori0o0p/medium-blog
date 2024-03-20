package usada.pekora.article.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import usada.pekora.article.model.Article;

public interface ArticleRepository extends ReactiveMongoRepository<Article, String> {
}
