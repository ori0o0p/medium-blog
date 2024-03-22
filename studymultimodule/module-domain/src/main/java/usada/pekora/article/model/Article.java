package usada.pekora.article.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import usada.pekora.comment.model.Comment;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@Document(collection = "article")
@NoArgsConstructor
public class Article {

    @Id
    private String id;
    private String title;
    private String content;

    @DocumentReference
    private List<Comment> comments = Collections.emptyList();

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addComent(Comment comment) {
        this.comments.add(comment);
    }

}
