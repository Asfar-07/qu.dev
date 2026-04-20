package com.example.qudev.repository;

import com.example.qudev.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    @Override
    Optional<Question> findById(Long id);
}
