package com.example.qudev.repository;

import com.example.qudev.model.question.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResponseRepo extends JpaRepository<SurveyResponse,Long> {
}
