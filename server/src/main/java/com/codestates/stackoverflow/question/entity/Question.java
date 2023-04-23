package com.codestates.stackoverflow.question.entity;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.codestates.stackoverflow.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String questionTitle;

    @Column(nullable = false)
    private String questionContent;

    @Column
    private int view;

    @Column(updatable = false)
    private LocalDateTime questionRegistDate = LocalDateTime.now();

    @Column
    private LocalDateTime questionModifyDate = LocalDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Answer> answers = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Builder
    public Question(Long questionId, String questionTitle, String questionContent, User user, Integer view){
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.user = user;
        this.view = view;
    }

}
