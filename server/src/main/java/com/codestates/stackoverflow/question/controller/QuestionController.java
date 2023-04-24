package com.codestates.stackoverflow.question.controller;

import com.codestates.stackoverflow.config.oauth.LoginUser;
import com.codestates.stackoverflow.question.dto.QuestionDto;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.question.mapper.QuestionMapper;
import com.codestates.stackoverflow.question.service.QuestionService;
import com.codestates.stackoverflow.user.dto.UserDto;
import com.codestates.stackoverflow.user.entity.User;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/boards/questions")
@Api(tags = "질문")
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;


    @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post requestBody
                                       ){
        requestBody.setUserId(1);
        Question question = mapper.questionPostToQuestion(requestBody);
        Question createdQuestion = questionService.createQuestion(question);

        return new ResponseEntity<>(mapper.questionToQuestionResponse(createdQuestion), HttpStatus.CREATED);
    }

    @PutMapping("/{question-id}")
    public ResponseEntity putQuestion(@PathVariable("question-id") long questionId,
                                      @RequestBody QuestionDto.Put requestBody
                                      ){
        requestBody.setUserId(5);
        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPutToQuestion(requestBody));

        return new ResponseEntity<>(mapper.questionToQuestionResponse(question),HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") long questionId){
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(mapper.questionToQuestionResponse(question),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@RequestParam int option){
        List<Question> questions = questionService.findQuestions(option);


        return new ResponseEntity<>(mapper.questionToQuestionResponses(questions), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") long questionId){
        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
