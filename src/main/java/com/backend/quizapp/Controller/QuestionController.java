package com.backend.quizapp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.quizapp.Entity.Question;
import com.backend.quizapp.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    
    @GetMapping("allQuestions")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }
}
