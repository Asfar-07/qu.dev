package com.example.qudev.model.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "surveys")
public class Surveys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name="survey_key",nullable = false, updatable = false, unique = true)
    private String key;

    @Lob
    @Column(nullable = false)
    private String description;

    private boolean active=true;
}
