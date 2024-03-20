package usada.pekora.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import usada.pekora.article.application.GetArticlePort;
import usada.pekora.article.application.SaveArticlePort;
import usada.pekora.comment.DeleteCommentUsecase;
import usada.pekora.comment.application.DeleteCommentPort;
import usada.pekora.comment.application.GetCommentPort;

@Service
@RequiredArgsConstructor
public class DeleteCommentService implements DeleteCommentUsecase {
    private final DeleteCommentPort deleteCommentPort;
    private final SaveArticlePort saveArticlePort;
    private final GetArticlePort getArticlePort;
    private final GetCommentPort getCommentPort;

    @Override
    public Mono<Void> deleteById(String commentId) {
        return getCommentPort.findById(commentId)
                .switchIfEmpty(Mono.error(new RuntimeException("댓글을 찾지 못했습니다.")))
                .flatMap(comment -> getArticlePort.findById(comment.article().getId())
                        .switchIfEmpty(Mono.error(new RuntimeException("게시물을 찾지 못했습니다.")))
                        .flatMap(article -> deleteCommentPort.deleteById(commentId)
                                .thenReturn(article)))
                .flatMap(saveArticlePort::save)
                .then();
    }

}
