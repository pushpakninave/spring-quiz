package com.backend.quizapp.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.quizapp.Entity.Question;
import com.backend.quizapp.Repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    
    public List<Question> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        Collections.sort(questions, Comparator.comparingInt(
            value -> value.getId()
            )
        );
        return questions;
    }
    
}
