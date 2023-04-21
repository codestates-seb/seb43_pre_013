package com.codestates.stackoverflow.comment.service;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.answer.repository.AnswerRepository;
import com.codestates.stackoverflow.answer.service.AnswerService;
import com.codestates.stackoverflow.comment.entity.Comment;
import com.codestates.stackoverflow.comment.repository.CommentRepository;
import com.codestates.stackoverflow.exception.BusinessLogicException;
import com.codestates.stackoverflow.exception.ExceptionCode;
import com.codestates.stackoverflow.user.entity.User;
import com.codestates.stackoverflow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final AnswerService answerService;
    private final UserRepository userRepository;


    public Comment createComment(Comment comment) {
        User findUser = findVerifiedUser(5);
        comment.setUser(findUser);
        Answer findAnswer = answerService.findVerifiedAnswer(comment.getAnswer().getAnswerId());
        List<Comment> comments = findAnswer.getComments();
        comments.add(comment);


        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        Comment verifiedComment = findVerifiedComment(comment.getCommentId());
        Answer findAnswer = answerService.findVerifiedAnswer(verifiedComment.getAnswer().getAnswerId());
        List<Comment> comments = findAnswer.getComments();

        Optional.ofNullable(comment.getText())
                .ifPresent(text -> verifiedComment.setText(text));
        verifiedComment.setCommentModifyDate(LocalDateTime.now());
        comments.removeIf(comment1 -> Objects.equals(comment1.getCommentId(),verifiedComment.getCommentId()));
        comments.add(verifiedComment);

        return commentRepository.save(verifiedComment);
    }

    public Comment findComment(long commentId) {
        Comment verifiedComment = findVerifiedComment(commentId);
        return verifiedComment;
    }

    public List<Comment> findAllComments() {

        return commentRepository.findAll();
    }

    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }

    private Comment findVerifiedComment(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        return findComment;
    }
    public User findVerifiedUser(long userId){
        Optional<User> optionalUser =
                userRepository.findById(userId);

        User finduser =
                optionalUser.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        return finduser;
    }

    public List<Comment> findCommentByPost(Long postId) {
        List<Comment> findComments = commentRepository.findAllByPostId(postId);
        return findComments;
    }

}
