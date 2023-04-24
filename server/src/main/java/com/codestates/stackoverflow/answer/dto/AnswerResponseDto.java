package com.codestates.stackoverflow.answer.dto;

import com.codestates.stackoverflow.answer.entity.Answer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerResponseDto {
    private Long answerId;
    private Long questionId;
    private String userName;
    private String answerTitle;
    private String answerContent;
    private LocalDateTime answerRegistDate;
    private LocalDateTime answerModifyDate;

    @Builder
    public AnswerResponseDto(Answer answer){
        this.answerId = answer.getAnswerId();
        this.questionId = answer.getQuestion().getQuestionId();
        this.userName = answer.getUser().getName();
        this.answerTitle = answer.getAnswerTitle();
        this.answerContent = answer.getAnswerContent();
        this.answerRegistDate = answer.getAnswerRegistDate();
        this.answerModifyDate = answer.getAnswerModifyDate();
    }
}
