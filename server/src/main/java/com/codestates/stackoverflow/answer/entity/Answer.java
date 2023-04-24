package com.codestates.stackoverflow.answer.entity;

import com.codestates.stackoverflow.comment.entity.Comment;
import com.codestates.stackoverflow.question.entity.Question;
import com.codestates.stackoverflow.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "answers")
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
    private LocalDateTime answerModifyDate = LocalDateTime.now();

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private AnswerStatus answerStatus = AnswerStatus.ANSWER_NOT_SELECT;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "answer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

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
