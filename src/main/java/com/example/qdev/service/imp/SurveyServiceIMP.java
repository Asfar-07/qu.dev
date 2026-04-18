package com.example.qdev.service.imp;

import com.example.qdev.model.question.Surveys;

import java.util.List;

public interface SurveyServiceIMP {

    public List listSurvey();
    public void addNewSurvey(Surveys survey);
}
