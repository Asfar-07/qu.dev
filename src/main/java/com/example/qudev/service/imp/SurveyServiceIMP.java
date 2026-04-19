package com.example.qudev.service.imp;

import com.example.qudev.model.question.Surveys;
import com.example.qudev.model.request.UpdateSurvey;
import com.example.qudev.repository.SurveysRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceIMP implements com.example.qudev.service.SurveyService {
    final SurveysRepo surveysRepo;

    public SurveyServiceIMP(SurveysRepo surveysRepo) {
        this.surveysRepo = surveysRepo;
    }

    @Override
    public List listSurvey() {
        return surveysRepo.findAll();
    }

    @Override
    public void addNewSurvey(Surveys survey) {

        Surveys surveys=surveysRepo.findByKey(survey.getKey()).orElse(null);
        if(surveys != null){
            throw new RuntimeException("Already Exited Key");
        }
        surveysRepo.save(survey);
    }

    @Override
    public void updateSurvey(String id, UpdateSurvey request) {
        Surveys item = surveysRepo.findByKey(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        // Partial update logic
        if (request.getName() != null) {
            item.setName(request.getName());
        }

        if (request.getDescription() != null) {
            item.setDescription(request.getDescription());
        }

        if (item.isActive() != request.isActive()) {
            item.setActive(request.isActive());
        }

        surveysRepo.save(item);
    }


}
