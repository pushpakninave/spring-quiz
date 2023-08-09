package com.backend.quizapp.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.quizapp.Entity.Question;
import com.backend.quizapp.Repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionRepository.findAll();
            Collections.sort(questions, Comparator.comparingInt(
                    value -> value.getId()));
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
        try {
            List<Question> sortQue = questionRepository.findByCategory(category);
            Collections.sort(sortQue, Comparator.comparingInt(
                    value -> value.getId()));
            return new ResponseEntity<>(sortQue, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Question questionx, Integer id) {

        try {
            String category = questionx.getCategory();
            String difficultyLevel = questionx.getDifficultyLevel();
            String option1 = questionx.getOption1();
            String option2 = questionx.getOption2();
            String option3 = questionx.getOption3();
            String option4 = questionx.getOption3();
            String question = questionx.getQuestion();
            String rightAnswer = questionx.getRightAnswer();
            questionRepository.updateQuestion(id, category, question, difficultyLevel, option1, option2, option3, option4, rightAnswer);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
    }

}
