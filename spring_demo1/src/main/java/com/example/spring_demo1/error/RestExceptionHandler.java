package com.example.spring_demo1.error;

import org.apache.http.HttpStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //other exception handlers

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.SC_BAD_REQUEST, "Entity not found", ex);
        return buildResponseEntity(apiError);
    }
    private ResponseEntity buildResponseEntity(ApiError apiError) {
        return new ResponseEntity(apiError, org.springframework.http.HttpStatus.valueOf(apiError.getStatus()));
    }
}