package com.example.qdev.controller;

import com.example.qdev.model.question.Surveys;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class SurveysController {

    @GetMapping("/surveys")
    public  String getSurvey(){
        return "surveys";
    }

    @PostMapping("/add/surveys")
    public void addSurvey(Surveys surveys){

    }

    @PutMapping("/update/survey")
    public void updateSurvey(){

    }

    @DeleteMapping("/delete/survey")
    public void deleteSurvey(){

    }

}
