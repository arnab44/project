package com.example.spring_demo1.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.apache.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
class ApiError {

    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    ApiError(int status) {
        this();
        this.status = status;
    }

    ApiError(int status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(int status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}