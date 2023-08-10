package com.backend.quizapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.quizapp.Entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{
    
}
