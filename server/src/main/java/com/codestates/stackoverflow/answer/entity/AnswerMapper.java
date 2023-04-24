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
        return new AnswerResponseDto(requsetDto);
                /*
                .builder()
                .answerId(requsetDto.getAnswerId())
                .questionId(requsetDto.getQuestion().getQuestionId())
                .userName(requsetDto.getUser().getName())
                .answerTitle(requsetDto.getAnswerTitle())
                .answerContent(requsetDto.getAnswerContent())
                .answerRegistDate(requsetDto.getAnswerRegistDate())
                .build();\

                 */
    }
}
