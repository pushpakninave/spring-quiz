package com.backend.quizapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.backend.quizapp.Entity.Question;

import jakarta.transaction.Transactional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Transactional
    @Modifying
    @Query(value = "UPDATE QUESTIONS SET CATEGORY= ?2, QUESTION = ?3, DIFFICULTYLEVEL = ?4, OPTION1 = ?5, OPTION2 = ?6, OPTION3 = ?7, OPTION4 = ?8, RIGHTANSWER = ?9 WHERE ID = ?1", nativeQuery = true)
    void updateQuestion(Integer id, String category, String question, String difficultyLevel, String option1,
            String option2, String option3, String option4, String rightAnswer);

}
