package com.codestates.stackoverflow.answer.controller;

import com.codestates.stackoverflow.answer.dto.AnswerDto;
import com.codestates.stackoverflow.answer.dto.AnswerRequestDto;
import com.codestates.stackoverflow.answer.dto.AnswerResponseDto;
import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.answer.mapper.AnswerMapper;
import com.codestates.stackoverflow.answer.service.AnswerService;
import com.codestates.stackoverflow.config.oauth.LoginUser;
import com.codestates.stackoverflow.user.dto.UserDto;
import com.codestates.stackoverflow.user.entity.User;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/answers")
@Api(tags = "답변")
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper mapper;

    /*@PostMapping("/{question-id}")
    public ResponseEntity createAnswer(@ApiIgnore @LoginUser UserDto user,
                                     @PathVariable("question-id") long questionId,
                                     @RequestBody AnswerDto.Post requestBody){
        requestBody.setUserId(5);
        requestBody.setQuestionId(questionId);
        Answer answer = mapper.answerPostToAnswer(requestBody);
        Answer createdAnswer = answerService.createAnswer(answer);

        return new ResponseEntity<>(mapper.answerToAnswerResponse(createdAnswer), HttpStatus.CREATED);
    }*/

    @PostMapping("/{questionId}")
    @ResponseBody
    public AnswerResponseDto createAnswer(//@ApiIgnore @LoginUser UserDto user,
                                          @PathVariable Long questionId,
                                          @RequestBody AnswerDto.Post answerRequestDto){

        return answerService.createAnswer(1L, questionId, answerRequestDto);
    }


    @PutMapping("/{answer-id}")
    @ResponseBody
    public ResponseEntity putAnswer(@PathVariable("answer-id") long answerId,
                                    @RequestBody AnswerDto.Put requestBody
                                    ){
        requestBody.setUserId(5);
        requestBody.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(mapper.answerPutToAnswer(requestBody));

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    @ResponseBody
    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId){
        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer), HttpStatus.OK);
    }

    @GetMapping("/answer/list")
    @ResponseBody
    public ResponseEntity getAnswers(){
        List<Answer> answers = answerService.findAnswers();

        return new ResponseEntity<>(mapper.answerToAnswerResponses(answers),HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    @ResponseBody
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId){
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

