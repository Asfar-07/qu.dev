package com.example.qudev.controller;

import com.example.qudev.model.question.Surveys;
import com.example.qudev.model.request.UpdateSurvey;
import com.example.qudev.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SurveysController {

    @Autowired
    SurveyService surveyService;

    @GetMapping("/surveys")
    public  String getSurvey(Model model){
        List listSurvey=surveyService.listSurvey();
        Surveys survey=new Surveys();

        model.addAttribute("survey", survey);
        model.addAttribute("listSurvey", listSurvey);
        return "surveys";
    }

    @PostMapping("/add/surveys")
    public String addSurvey(Surveys survey, Model model){
        surveyService.addNewSurvey(survey);
        return "redirect:/surveys";
    }

    @DeleteMapping("/delete/survey")
    public void deleteSurvey(){

    }

}
