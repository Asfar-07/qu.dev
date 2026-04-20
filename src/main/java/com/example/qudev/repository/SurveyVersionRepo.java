package com.example.qudev.repository;

import com.example.qudev.model.question.SurveyVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyVersionRepo extends JpaRepository<SurveyVersion,Long> {
}
