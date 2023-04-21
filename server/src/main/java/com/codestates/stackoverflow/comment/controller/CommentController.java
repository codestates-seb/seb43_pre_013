package com.codestates.stackoverflow.comment.controller;

import com.codestates.stackoverflow.comment.dto.CommentDto;
import com.codestates.stackoverflow.comment.entity.Comment;
import com.codestates.stackoverflow.comment.mapper.CommentMapper;
import com.codestates.stackoverflow.comment.service.CommentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final or @Not Null이 붙은 필드의 생성자를 자동 생성
@RequestMapping("boards/comments")
@Api(tags = "댓글")
public class CommentController {

    private final CommentMapper commentMapper;
    private final CommentService commentService;

    @PostMapping("/{post-id}")
    public ResponseEntity postComment(@PathVariable("post-id") long postId,
                                      @RequestBody CommentDto.Post commentDto) {
        commentDto.setUserId(5);
        commentDto.setAnswerId(postId);
        Comment comment = commentMapper.commentPostDtoToComment(commentDto);
        Comment findComment = commentService.createComment(comment);
        CommentDto.Response response = commentMapper.commentToResponseDto(findComment);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") Long commentId,
                                       @RequestBody CommentDto.Patch patchDto) {
        patchDto.setUserId(5);
        patchDto.setCommentId(commentId);
        Comment comment = commentMapper.commentPatchDtoToComment(patchDto);
        Comment findComment = commentService.updateComment(comment);
        CommentDto.Response response = commentMapper.commentToResponseDto(findComment);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{comment-id}")
    public ResponseEntity getComment(@PathVariable("comment-id") Long commentId) {
        Comment findComment = commentService.findComment(commentId);
        CommentDto.Response response = commentMapper.commentToResponseDto(findComment);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getComments() {
        List<Comment> allComments = commentService.findAllComments();
        List<CommentDto.Response> responses = commentMapper.commentsToResponseDtos(allComments);

        return new ResponseEntity(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") Long commentId) {
        commentService.deleteComment(commentId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
