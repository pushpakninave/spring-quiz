package com.backend.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.quizapp.Entity.QuizQuestionWrapper;
import com.backend.quizapp.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQue,
            @RequestParam String title) {
        return quizService.createQuiz(category, numQue, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuizQuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }
}
