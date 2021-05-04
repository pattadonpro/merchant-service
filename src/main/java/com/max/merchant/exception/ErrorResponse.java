package com.max.merchant.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Getter
public class ErrorResponse {
    private Date timestamp;
    private int status;
    private String message;
    private List<Map<String, String>> fieldErrors;
    private String path;
}
