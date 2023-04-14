package com.codestates.stackoverflow.question.mapper;

import com.codestates.stackoverflow.question.dto.QuestionDto;
import com.codestates.stackoverflow.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostToQuestion(QuestionDto.Post requestBody);
    Question questionPutToQuestion(QuestionDto.Put requestBody);
    QuestionDto.response questionToQuestionResponse(Question question);
    List<QuestionDto.responses> questionToQuestionResponses(List<Question> questions);
}
