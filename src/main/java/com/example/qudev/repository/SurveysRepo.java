package com.example.qudev.repository;

import com.example.qudev.model.question.Surveys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveysRepo extends JpaRepository<Surveys,Long> {
    @Override
    Optional<Surveys> findById(Long id);
    Optional<Surveys> findByKey(String key);
}
