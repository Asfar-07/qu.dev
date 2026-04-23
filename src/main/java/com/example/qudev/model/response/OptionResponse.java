package com.example.qudev.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OptionResponse {

    private String key;
    private String label;
}
