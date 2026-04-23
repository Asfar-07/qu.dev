package com.example.qudev.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class QuestionResponse {
    private Long id;
    private String key;
    private String text;
    private String type;
    private boolean required;
    private List<OptionResponse> options;
}
