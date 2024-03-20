package usada.pekora.comment.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import usada.pekora.article.model.Article;

@Builder
@Document(collection = "article_comment")
public record Comment(
        @Id
        String id,
        String content,
        @DocumentReference
        Article article
) {
}
