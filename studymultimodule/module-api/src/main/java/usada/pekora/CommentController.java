package usada.pekora;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import usada.pekora.comment.CreateCommentUsecase;
import usada.pekora.comment.DeleteCommentUsecase;
import usada.pekora.comment.model.dto.CreateCommentRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CreateCommentUsecase createCommentUsecase;
    private final DeleteCommentUsecase deleteCommentUsecase;

    @PostMapping("/{articleId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@PathVariable String articleId, @RequestBody CreateCommentRequest request) {
        return createCommentUsecase.create(articleId, request);
    }

    @DeleteMapping("/comments/{commentId}")
    public Mono<Void> delete(@PathVariable String commentId) {
        return deleteCommentUsecase.deleteById(commentId);
    }

}
