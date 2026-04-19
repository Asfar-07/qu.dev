package com.example.qudev.model.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateSurvey {
    private String name;
    private String description;
    private boolean active;
}
