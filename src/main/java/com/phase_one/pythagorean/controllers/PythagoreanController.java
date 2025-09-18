package com.phase_one.pythagorean.controllers;

import com.phase_one.pythagorean.dtos.PythagoreanValuesResponse;
import com.phase_one.pythagorean.services.PythagoreanService;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/api/pythagorean")
public class PythagoreanController {

    private final PythagoreanService pythagoreanService;

    @GetMapping("/calculate-pythagorean-sides/{value}")
    public ResponseEntity<?> calculatePythagoreanSides (@PathVariable @Min(1) Long value) {
        PythagoreanValuesResponse pythagoreanValuesResponse = pythagoreanService.calculatePythagoreanSides(value);
        return ResponseEntity.ok().body(pythagoreanValuesResponse);
    }
}
