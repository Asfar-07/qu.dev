package com.example.qdev.service;

import com.example.qdev.model.question.Surveys;
import com.example.qdev.repository.SurveysRepo;
import com.example.qdev.service.imp.SurveyServiceIMP;

import java.util.List;

public class SurveyService implements SurveyServiceIMP {
    final SurveysRepo surveysRepo;

    public SurveyService(SurveysRepo surveysRepo) {
        this.surveysRepo = surveysRepo;
    }

    @Override
    public List listSurvey() {
        return surveysRepo.findAll();
    }

    @Override
    public void addNewSurvey(Surveys survey) {
        surveysRepo.save(survey);
    }


}
