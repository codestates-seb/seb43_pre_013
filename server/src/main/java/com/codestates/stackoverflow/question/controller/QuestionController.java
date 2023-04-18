package com.codestates.stackoverflow.question.controller;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.answer.mapper.AnswerMapper;
import com.codestates.stackoverflow.answer.service.AnswerService;
import com.codestates.stackoverflow.dto.MultiResponseDto;
import com.codestates.stackoverflow.question.dto.QuestionDto;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.question.mapper.QuestionMapper;
import com.codestates.stackoverflow.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final QuestionMapper mapper;

    private final AnswerMapper mapper2;

    public QuestionController(QuestionService questionService,AnswerService answerService, QuestionMapper mapper, AnswerMapper mapper2){
        this.questionService = questionService;
        this.answerService = answerService;
        this.mapper = mapper;
        this.mapper2 = mapper2;
    }

    @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post requestBody){
        Question question = mapper.questionPostToQuestion(requestBody);
        Question createdQuestion = questionService.createQuestion(question);

        return new ResponseEntity<>(mapper.questionToQuestionResponse(createdQuestion), HttpStatus.CREATED);
    }

    @PutMapping("/{question-id}")
    public ResponseEntity putQuestion(@PathVariable("question-id") long questionId,
                                      @RequestBody QuestionDto.Put requestBody){
        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPutToQuestion(requestBody));

        return new ResponseEntity<>(mapper.questionToQuestionResponse(question),HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") long questionId){
        Question question = questionService.findQuestion(questionId);
        //List<Answer> answers = answerService.findAnswers();

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
