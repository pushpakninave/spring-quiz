package com.backend.quizapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.quizapp.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    
}
