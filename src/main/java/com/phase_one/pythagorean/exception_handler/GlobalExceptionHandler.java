package com.phase_one.pythagorean.exception_handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(Map.of("message: ", "Enter a value that is not negative"));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        if (ex.getRequiredType() == Long.class) {
            String value = Objects.requireNonNull(ex.getValue()).toString();
            // if value entered is decimal
            if (value.matches("\\d+\\.\\d+")) {
                return ResponseEntity.badRequest().body(Map.of("message: ",
                        "Invalid Input, enter a Whole Number"));
            }

            //fall back if other datatype is entered (not a long data type)
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input",
                    "message", "Path variable must be a number of type Long"));
        }

        //default fallback
        return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input",
                "message", "Type mismatch for parameter: " + ex.getName()));
    }
}
