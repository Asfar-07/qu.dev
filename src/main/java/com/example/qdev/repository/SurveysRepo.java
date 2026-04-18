package com.example.qdev.repository;

import com.example.qdev.model.question.Surveys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveysRepo extends JpaRepository<Surveys,Long> {
    @Override
    Optional<Surveys> findById(Long id);

}
