package com.codestates.stackoverflow.answer.entity;

import com.codestates.stackoverflow.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String answerTitle;

    @Column(nullable = false)
    private String answerContent;

    @Column(updatable = false)
    private LocalDateTime answerRegistDate = LocalDateTime.now();

    @Column
    private LocalDateTime answerModifyDate;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private AnswerStatus answerStatus = AnswerStatus.ANSWER_NOT_SELECT;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;



    public void setQuestion(Question question){
        this.question = question;
    }

    public enum AnswerStatus{
        ANSWER_SELECT("답변 채택"),
        ANSWER_NOT_SELECT("답변 미채택");

        @Getter
        private String status;

        AnswerStatus(String status) {
            this.status = status;
        }
    }

}
