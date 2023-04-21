package com.codestates.stackoverflow.comment.dto;


import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.user.dto.UserDto;
import com.codestates.stackoverflow.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        private long userId;
        private Long commentId;
        private long answerId;
        private String text;

        public void setUserId(long userId){
            this.userId = userId;
        }
        public void setAnswerId(long answerId){
            this.answerId = answerId;
        }

        public Answer getAnswer(){
            Answer answer = new Answer();
            answer.setAnswerId(answerId);

            return answer;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {

        private long userId;
        private long commentId;
        private String text;

        public void setUserId(long userId){
            this.userId = userId;
        }
        public void setCommentId(long commentId){
            this.commentId = commentId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private User user;
        private long commentId;
        private String text;
        private LocalDateTime commentRegistDate;
        private LocalDateTime commentModifyDate;
    }
}
