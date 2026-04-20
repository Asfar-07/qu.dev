package com.example.qudev.repository;

import com.example.qudev.model.question.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepo extends JpaRepository<Survey,Long> {
    @Override
    Optional<Survey> findById(Long id);
    Optional<Survey> findByKey(String key);
}
