package com.backend.quizapp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategery(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);
    }
    
    // add
    @PostMapping("addQuestion") 
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // delete 
    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    // update
    @PutMapping("updateQuestion/{id}")
    public String updateQuestion(@RequestBody Question question, @PathVariable Integer id){
        return questionService.updateQuestion(question, id);
    }
}
