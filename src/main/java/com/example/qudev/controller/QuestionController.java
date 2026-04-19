package com.example.qudev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @GetMapping("/questions/{id}")
    public  String Question(){
        return "questions";
    }
}
