package com.example.qudev.repository;

import com.example.qudev.model.question.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions,Long> {
    @Override
    Optional<Questions> findById(Long id);
}
