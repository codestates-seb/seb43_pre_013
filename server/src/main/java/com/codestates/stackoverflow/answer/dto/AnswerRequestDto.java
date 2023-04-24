package com.codestates.stackoverflow.answer.dto;

import com.codestates.stackoverflow.answer.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerRequestDto {
    private Long questionId;
    private String answerTitle;
    private String answerContent;
}
