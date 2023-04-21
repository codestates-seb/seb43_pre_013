package com.codestates.stackoverflow.question.dto;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.user.dto.UserDto;
import com.codestates.stackoverflow.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


public class QuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        private long userId;
        private String questionTitle;
        private String questionContent;

        public void setUserId(long userId){
            this.userId = userId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Put{
        private long userId;
        private long questionId;
        private String questionTitle;
        private String questionContent;

        public void setQuestionId(long questionId){
            this.questionId = questionId;
        }

        public void setUserId(long userId){
            this.userId = userId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class response{
        private User user;
        private long questionId;
        private String questionTitle;
        private String questionContent;
        private int view;
        private LocalDateTime questionRegistDate;
        private List<Answer> answers;
    }

    @Getter
    @AllArgsConstructor
    public static class responses{
        private long questionId;
        private String questionTitle;
        private int view;
        private LocalDateTime questionRegistDate;
    }

}
