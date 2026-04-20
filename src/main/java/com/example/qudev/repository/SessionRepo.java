package com.example.qudev.repository;

import com.example.qudev.model.question.UserSurveySession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<UserSurveySession,Long> {
}
