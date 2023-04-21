package com.codestates.stackoverflow.answer.service;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.answer.repository.AnswerRepository;
import com.codestates.stackoverflow.exception.BusinessLogicException;
import com.codestates.stackoverflow.exception.ExceptionCode;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.question.service.QuestionService;
import com.codestates.stackoverflow.user.entity.User;
import com.codestates.stackoverflow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AnswerService {
    private final QuestionService questionService;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;


    public Answer createAnswer(Answer answer){
        Question findquestion = questionService.findVerifiedQuestion(answer.getQuestion().getQuestionId());
        List<Answer> answers = findquestion.getAnswers();
        answers.add(answer);
        User finduser = questionService.findVerifiedUser(5);
        answer.setUser(finduser);

        Answer savedAnswer = answerRepository.save(answer);

        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer){
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        Question findquestion = questionService.findVerifiedQuestion(findAnswer.getQuestion().getQuestionId());
        List<Answer> answers = findquestion.getAnswers();

        Optional.ofNullable(answer.getAnswerTitle())
                .ifPresent(title -> findAnswer.setAnswerTitle(title));
        Optional.ofNullable(answer.getAnswerContent())
                .ifPresent(content -> findAnswer.setAnswerContent(content));
        findAnswer.setAnswerModifyDate(LocalDateTime.now());
        findAnswer.setAnswerStatus(answer.getAnswerStatus());
        answers.removeIf(answer1 -> Objects.equals(answer1.getAnswerId(), findAnswer.getAnswerId()));
        answers.add(findAnswer);


        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(long answerId){
        Answer answer = findVerifiedAnswer(answerId);

        return answer;
    }

    public List<Answer> findAnswers(){

        return answerRepository.findAll(Sort.by("answerStatus"));
    }

    public void deleteAnswer(long answerId){
        Answer findAnswer = findVerifiedAnswer(answerId);

        answerRepository.delete(findAnswer);
    }

    public Answer findVerifiedAnswer(long answerId){
        Optional<Answer> optionalAnswer =
                answerRepository.findById(answerId);

        Answer findAnswer =
                optionalAnswer.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }

    public User findVerifiedUser(long userId){
        Optional<User> optionalUser =
                userRepository.findById(userId);

        User finduser =
                optionalUser.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        return finduser;
    }
}
