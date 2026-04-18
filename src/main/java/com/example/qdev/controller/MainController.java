package com.example.qdev.controller;

import com.example.qdev.model.response.ConnectionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @GetMapping("/")
    public String Home(){
        return "home";
    }

    @GetMapping("/connection")
    public  String Connect(Model model){
        ConnectionDTO res=new ConnectionDTO(dbUrl);
        model.addAttribute("response", res);
        return "connection";
    }

    @GetMapping("/questions")
    public  String Question(){
        return "questions";
    }

    @GetMapping("/documentation")
    public  String Documentation(){
        return "<h1>DOC</h1>";
    }

}
