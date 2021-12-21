package com.github.mattnicee7.resources.exceptions;

import com.github.mattnicee7.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException exception, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(standardError);
    }

}
