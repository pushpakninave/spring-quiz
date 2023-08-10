package com.backend.quizapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.quizapp.Entity.Question;
import com.backend.quizapp.Entity.Quiz;
import com.backend.quizapp.Entity.QuizQuestionWrapper;
import com.backend.quizapp.Repository.QuestionRepository;
import com.backend.quizapp.Repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository; 

    public ResponseEntity<String> createQuiz(String category, Integer numQue, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQue);
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestion(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuizQuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestion();
        List<QuizQuestionWrapper> questionsForQuiz = new ArrayList<>();
        
        for(Question q : questionsFromDB){
            QuizQuestionWrapper qqw = new QuizQuestionWrapper(q.getId(), q.getCategory(), q.getDifficultyLevel(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(),q.getQuestion());
            questionsForQuiz.add(qqw);
        }

        return new ResponseEntity<List<QuizQuestionWrapper>>(questionsForQuiz, HttpStatus.OK);
    }
}
