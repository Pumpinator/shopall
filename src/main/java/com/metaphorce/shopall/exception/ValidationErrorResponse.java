package com.metaphorce.shopall.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude
@Data
public class ValidationErrorResponse {

    private String message;
    private List<String> errors;

    public ValidationErrorResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }
}
