package com.example.qudev.service;

import com.example.qudev.model.question.Survey;
import com.example.qudev.model.request.UpdateSurvey;

import java.util.List;

public interface SurveyService {

    public List listSurvey();
    public void addNewSurvey(Survey survey);
    public void updateSurvey(String id, UpdateSurvey request);
}
