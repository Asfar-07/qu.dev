package com.example.qdev.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class ApiController {
    private final DataSource dataSource;

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
}
