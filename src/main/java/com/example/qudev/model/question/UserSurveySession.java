package com.example.qudev.model.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "user_survey_sessions")
public class UserSurveySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String status;

    private LocalDateTime startedAt;

    @ManyToOne
    @JoinColumn(name = "ver_id", nullable = false)
    private SurveyVersion surveyVersion;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<SurveyResponse> responses= new ArrayList<>();

}
