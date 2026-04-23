package com.example.qudev.service;


import com.example.qudev.model.request.QuestionRequest;
import com.example.qudev.model.response.SurveyVersionResponse;

import java.util.List;

public interface QuestionService {

    void saveQuestion(Long versionId, QuestionRequest request);
    SurveyVersionResponse collectQuestion(long versionId);
}
