package com.codestates.stackoverflow.answer.mapper;

import com.codestates.stackoverflow.answer.dto.AnswerDto;
import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.question.entity.Question;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
//@ComponentScan(basePackages = "com.codestates.stackoverflow.answer.mapper.AnswerMapper")
@Mapper (componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostToAnswer(AnswerDto.Post requestBody);
    Answer answerPutToAnswer(AnswerDto.Put requestBody);
    AnswerDto.response answerToAnswerResponse(Answer answer);
    List<AnswerDto.response> answerToAnswerResponses(List<Answer> answers);
}
