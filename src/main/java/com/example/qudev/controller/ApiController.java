package com.example.qudev.controller;
import com.example.qudev.model.request.UpdateSurvey;
import com.example.qudev.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class ApiController {
    private final DataSource dataSource;

    @Autowired
    SurveyService surveyService;

    public ApiController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/check-db")
    public String checkDb() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(2)) {
                return "✅ DB Connection SUCCESS";
            } else {
                return "❌ DB Connection FAILED";
            }
        } catch (Exception e) {
            return "❌ DB Connection FAILED: " + e.getMessage();
        }
    }
    @PutMapping("/update/survey/{id}")
    public ResponseEntity<String> updateSurvey(@PathVariable String id,
                                       @RequestBody UpdateSurvey request){
        System.out.println(id);
        surveyService.updateSurvey(id,request);
        return  ResponseEntity.ok("ok");
    }
}
