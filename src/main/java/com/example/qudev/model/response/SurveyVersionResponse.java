package com.example.qudev.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SurveyVersionResponse {

    private Long versionId;
    private List<QuestionResponse> questions;
}
