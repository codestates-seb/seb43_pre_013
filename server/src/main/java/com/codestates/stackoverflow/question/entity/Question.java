package com.codestates.stackoverflow.question.entity;

import com.codestates.stackoverflow.answer.entity.Answer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
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
    private LocalDateTime questionModifyDate;

    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Answer> answers = new ArrayList<>();

}
