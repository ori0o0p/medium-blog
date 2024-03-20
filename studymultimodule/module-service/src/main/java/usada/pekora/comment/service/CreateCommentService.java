package usada.pekora.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import usada.pekora.article.application.GetArticlePort;
import usada.pekora.comment.CreateCommentUsecase;
import usada.pekora.comment.application.CreateCommentPort;
import usada.pekora.comment.model.Comment;
import usada.pekora.comment.model.dto.CreateCommentRequest;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CreateCommentUsecase {
    private final CreateCommentPort createCommentPort;
    private final GetArticlePort getArticlePort;

    @Override
    public Mono<Void> create(String articleId, CreateCommentRequest request) {
        return getArticlePort.findById(articleId)
                .switchIfEmpty(Mono.error(new RuntimeException("게시물을  찾지 못했습니다.")))
                .flatMap(article -> createCommentPort.create(Comment.builder()
                        .content(request.content())
                        .article(article)
                        .build()))
                .then();
    }

}
