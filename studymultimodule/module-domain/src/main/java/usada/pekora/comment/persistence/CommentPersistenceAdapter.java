package usada.pekora.comment.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import usada.pekora.comment.application.CreateCommentPort;
import usada.pekora.comment.application.DeleteCommentPort;
import usada.pekora.comment.application.GetCommentPort;
import usada.pekora.comment.model.Comment;
import usada.pekora.comment.repository.CommentRepository;

@Component
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements CreateCommentPort, DeleteCommentPort, GetCommentPort {
    private final CommentRepository commentRepository;

    @Override
    public Mono<Comment> create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Mono<Void> delete(Comment comment) {
        return commentRepository.delete(comment);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return commentRepository.deleteById(id);
    }

    /**
     * for cascade
     */
    @Override
    public Flux<Void> deleteAllByArticleId(String articleId) {
        return commentRepository.deleteAllByArticle_Id(articleId);
    }

    @Override
    public Mono<Comment> findById(String id) {
        return commentRepository.findById(id);
    }

}
