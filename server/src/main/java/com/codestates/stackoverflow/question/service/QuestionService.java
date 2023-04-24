package com.codestates.stackoverflow.question.service;

import com.codestates.stackoverflow.exception.BusinessLogicException;
import com.codestates.stackoverflow.exception.ExceptionCode;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.question.repository.QuestionRepository;
import com.codestates.stackoverflow.user.entity.User;
import com.codestates.stackoverflow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;


    public Question createQuestion(Question question){
        User findUser = findVerifiedUser(1);
        question.setUser(findUser);

        Question savedQuestion = questionRepository.save(question);

        return savedQuestion;
    }

    public Question updateQuestion(Question question){
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        Optional.ofNullable(question.getQuestionTitle())
                .ifPresent(title -> findQuestion.setQuestionTitle(title));
        Optional.ofNullable(question.getQuestionContent())
                .ifPresent(content -> findQuestion.setQuestionContent(content));
        findQuestion.setQuestionModifyDate(LocalDateTime.now());

        return questionRepository.save(findQuestion);
    }

    public Question findQuestion(long questionId){
        Question question = findVerifiedQuestion(questionId);
        question.setView(question.getView() + 1);
        questionRepository.save(question);

        return question;
    }

    public List<Question> findQuestions(int option){
        if(option == 1){
            return questionRepository.findAll(Sort.by("questionId"));
        } else if (option == 2) {
            return questionRepository.findAll(Sort.by("view").descending());

        } else{
            return questionRepository.findAll(Sort.by("questionRegistDate").descending());
        }
    }

    public void deleteQuestion(long questionId){
        Question findQuestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findQuestion);
    }

    public Question findVerifiedQuestion(long questionId){
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);

        Question findQuestion =
                optionalQuestion.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
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
