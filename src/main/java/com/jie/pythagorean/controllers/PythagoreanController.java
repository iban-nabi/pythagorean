package com.jie.pythagorean.controllers;

import com.jie.pythagorean.dtos.PythagoreanValuesResponse;
import com.jie.pythagorean.services.PythagoreanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

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
