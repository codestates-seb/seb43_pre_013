package com.codestates.stackoverflow.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class QuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        private String questionTitle;
        private String questionContent;
    }

    @Getter
    @AllArgsConstructor
    public static class Put{
        private long questionId;
        private String questionTitle;
        private String questionContent;

        public void setQuestionId(long questionId){
            this.questionId = questionId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class response{
        private long questionId;
        private String questionTitle;
        private String questionContent;
        private int view;
        private LocalDateTime questionRegistDate;
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
