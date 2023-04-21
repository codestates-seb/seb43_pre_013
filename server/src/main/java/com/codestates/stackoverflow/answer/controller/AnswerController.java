package com.codestates.stackoverflow.answer.controller;

import com.codestates.stackoverflow.answer.dto.AnswerDto;
import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.answer.mapper.AnswerMapper;
import com.codestates.stackoverflow.answer.service.AnswerService;
import com.codestates.stackoverflow.config.oauth.LoginUser;
import com.codestates.stackoverflow.user.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/boards/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    public AnswerController(AnswerService answerService, AnswerMapper mapper){
        this.answerService = answerService;
        this.mapper = mapper;
    }

    @PostMapping("/{question-id}")
    public ResponseEntity postAnswer(@PathVariable("question-id") long questionId,
                                     @RequestBody AnswerDto.Post requestBody
                                     ){
        requestBody.setUserId(5);
        requestBody.setQuestionId(questionId);
        Answer answer = mapper.answerPostToAnswer(requestBody);
        Answer createdAnswer = answerService.createAnswer(answer);

        return new ResponseEntity<>(mapper.answerToAnswerResponse(createdAnswer), HttpStatus.CREATED);
    }

    @PutMapping("/*/{answer-id}")
    public ResponseEntity putAnswer(@PathVariable("answer-id") long answerId,
                                    @RequestBody AnswerDto.Put requestBody
                                    ){
        requestBody.setUserId(5);
        requestBody.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(mapper.answerPutToAnswer(requestBody));

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer), HttpStatus.OK);
    }

    @GetMapping("/*/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId){
        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(){
        List<Answer> answers = answerService.findAnswers();

        return new ResponseEntity<>(mapper.answerToAnswerResponses(answers),HttpStatus.OK);
    }

    @DeleteMapping("/*/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId){
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
