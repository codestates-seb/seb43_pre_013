package com.codestates.stackoverflow.dto;

import com.codestates.stackoverflow.answer.dto.AnswerDto;
import com.codestates.stackoverflow.answer.entity.Answer;
import lombok.Getter;

import java.util.List;


@Getter
public class MultiResponseDto<T> {

    private T question;
    private List<AnswerDto.response> answer;

    public MultiResponseDto(T question, List<AnswerDto.response> answer){
        this.question = question;
        this.answer = answer;
    }
}
