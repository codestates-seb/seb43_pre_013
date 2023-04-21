package com.codestates.stackoverflow.answer.service;

import com.codestates.stackoverflow.answer.dto.AnswerRequestDto;
import com.codestates.stackoverflow.answer.dto.AnswerResponseDto;
import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.answer.entity.AnswerMapper;
import com.codestates.stackoverflow.answer.repository.AnswerRepository;
import com.codestates.stackoverflow.exception.BusinessLogicException;
import com.codestates.stackoverflow.exception.ExceptionCode;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.question.repository.QuestionRepository;
import com.codestates.stackoverflow.question.service.QuestionService;
import com.codestates.stackoverflow.user.entity.User;
import com.codestates.stackoverflow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AnswerService {
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;



    @Transactional
    public AnswerResponseDto createAnswer(Long userId, Long questionId, AnswerRequestDto answerRequestDto){
        Optional<User> user = userRepository.findById(userId);
        Question question = questionRepository.findById(questionId).orElseThrow();

        Answer answer = AnswerMapper.toAnswerEntity(answerRequestDto);
        answer.setQuestion(question);
        answer.setUser(user.get());
        Answer queryResult = answerRepository.save(answer);

        return AnswerMapper.toAnswerResponseDto(queryResult);
    }

    @Transactional
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

    @Transactional
    public Answer findAnswer(long answerId){
        Answer answer = findVerifiedAnswer(answerId);

        return answer;
    }

    @Transactional
    public List<Answer> findAnswers(){

        return answerRepository.findAll(Sort.by("answerStatus"));
    }

    @Transactional
    public void deleteAnswer(long answerId){
        Answer findAnswer = findVerifiedAnswer(answerId);

        answerRepository.delete(findAnswer);
    }

    @Transactional
    public Answer findVerifiedAnswer(long answerId){
        Optional<Answer> optionalAnswer =
                answerRepository.findById(answerId);

        Answer findAnswer =
                optionalAnswer.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }

    @Transactional
    public User findVerifiedUser(long userId){
        Optional<User> optionalUser =
                userRepository.findById(userId);

        User finduser =
                optionalUser.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        return finduser;
    }
}
