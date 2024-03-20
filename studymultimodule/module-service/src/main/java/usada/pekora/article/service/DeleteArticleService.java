package usada.pekora.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import usada.pekora.article.DeleteArticleUsecase;
import usada.pekora.article.application.DeleteArticlePort;
import usada.pekora.comment.application.DeleteCommentPort;

@Service
@RequiredArgsConstructor
public class DeleteArticleService implements DeleteArticleUsecase {
    private final DeleteArticlePort deleteArticlePort;
    private final DeleteCommentPort deleteCommentPort;

    @Override
    public Mono<Void> deleteById(String articleId) {
        return Mono.when(deleteArticlePort.deleteById(articleId),
                deleteCommentPort.deleteAllByArticleId(articleId));
    }

}
