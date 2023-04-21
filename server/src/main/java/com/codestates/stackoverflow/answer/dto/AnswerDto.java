package com.codestates.stackoverflow.answer.dto;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.comment.entity.Comment;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


public class AnswerDto {

    @Getter
    @AllArgsConstructor
    public static class Post{

        private long userId;
        private long questionId;
        private String answerTitle;
        private String answerContent;

        public void setUserId(long userId){
            this.userId = userId;
        }
        public void setQuestionId(long questionId){
            this.questionId = questionId;
        }

        public Question getQuestion(){
            Question question = new Question();
            question.setQuestionId(questionId);

            return question;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Put{
        private long userId;
        private Long answerId;
        private String answerTitle;
        private String answerContent;
        private Answer.AnswerStatus answerStatus;

        public void setUserId(long userId){
            this.userId = userId;
        }
        public void setAnswerId(long answerId){
            this.answerId = answerId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class response{

        private User user;
        private long answerId;
        private String answerTitle;
        private String answerContent;
        private LocalDateTime answerRegistDate;
        private Answer.AnswerStatus answerStatus;
        private List<Comment> comments;

        public String getAnswerStatus(){
            return answerStatus.getStatus();
        }

    }
}
