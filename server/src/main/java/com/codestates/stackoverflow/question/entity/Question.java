package com.codestates.stackoverflow.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column
    private String questionTitle;

    @Column
    private String questionContent;

    @Column
    private int view;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime questionRegistDate = LocalDateTime.now();

    @Column
    private LocalDateTime questionModifyDate = null;

}
