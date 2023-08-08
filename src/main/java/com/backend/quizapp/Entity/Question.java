package com.backend.quizapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "QUESTIONS")
public class Question {
    @Id
    @GeneratedValue(
        // since we are using oracle db we need to use GenerationType.SEQUENCE because oracle does not have autoincrementing column feature.
        strategy = GenerationType.SEQUENCE 
    )
    private Integer id;
    private String category;
    @Column(name = "DIFFICULTYLEVEL")
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question;
    @Column(name = "RIGHTANSWER")
    private String rightAnswer;
}
