package com.codestates.stackoverflow.answer.entity;

import com.codestates.stackoverflow.answer.dto.AnswerRequestDto;
import com.codestates.stackoverflow.answer.dto.AnswerResponseDto;
import com.codestates.stackoverflow.answer.entity.Answer;

public class AnswerMapper {
    public static Answer toAnswerEntity(AnswerRequestDto requestDto){
        return Answer.builder()
                .answerTitle(requestDto.getAnswerTitle())
                .answerContent(requestDto.getAnswerContent())
                .build();
    }

    public static AnswerResponseDto toAnswerResponseDto(Answer requsetDto){
        return AnswerResponseDto.builder()
                .questionId(requsetDto.getAnswerId())
                .answerTitle(requsetDto.getAnswerTitle())
                .answerContent(requsetDto.getAnswerContent())
                .build();
    }
}
