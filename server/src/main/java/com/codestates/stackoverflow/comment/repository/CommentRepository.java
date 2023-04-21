package com.codestates.stackoverflow.comment.repository;

import com.codestates.stackoverflow.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT c FROM Comment c WHERE c.commentId = :commentId")
    List<Comment> findAllByPostId(Long commentId);
}
