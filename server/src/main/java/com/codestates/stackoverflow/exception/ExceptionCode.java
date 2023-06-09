package com.codestates.stackoverflow.exception;

import lombok.Getter;


public enum ExceptionCode {
    QUESTION_NOT_FOUND(404, "Question not found"),
    ANSWER_NOT_FOUND(404, "Answer not found"),
    COMMENT_NOT_FOUND(404,"Comment not found"),
    USER_NOT_FOUND(404, "User not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }
}
