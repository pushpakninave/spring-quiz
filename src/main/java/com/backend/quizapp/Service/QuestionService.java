package com.backend.quizapp.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.quizapp.Entity.Question;
import com.backend.quizapp.Repository.QuestionRepository;

import jakarta.persistence.Column;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        Collections.sort(questions, Comparator.comparingInt(
                value -> value.getId()));
        return questions;
    }

    public List<Question> getAllQuestionsByCategory(String category) {
        List<Question> sortQue = questionRepository.findByCategory(category);
        Collections.sort(sortQue, Comparator.comparingInt(
                value -> value.getId()));
        return sortQue;
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "success";
    }

    public String deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return "deleted";
    }

    public String updateQuestion(Question questionx, Integer id) {
        
        String category = questionx.getCategory();
        String difficultyLevel = questionx.getDifficultyLevel();
        String option1 = questionx.getOption1();
        String option2 = questionx.getOption2();
        String option3 = questionx.getOption3();
        String option4 = questionx.getOption3();
        String question = questionx.getQuestion();
        String rightAnswer = questionx.getRightAnswer();
        questionRepository.updateQuestion(id, category, question, difficultyLevel, option1, option2, option3, option4, rightAnswer);
        return "success";
    }

}
