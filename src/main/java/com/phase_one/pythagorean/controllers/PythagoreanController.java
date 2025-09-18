package com.phase_one.pythagorean.controllers;

import com.phase_one.pythagorean.dtos.PythagoreanValuesResponse;
import com.phase_one.pythagorean.services.PythagoreanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pythagorean")
public class PythagoreanController {

    private final PythagoreanService pythagoreanService;

    @GetMapping("/calculate-pythagorean-sides/{value}")
    public ResponseEntity<?> calculatePythagoreanSides (@PathVariable Long value) {
        PythagoreanValuesResponse pythagoreanValuesResponse = pythagoreanService.calculatePythagoreanSides(value);
        return ResponseEntity.ok().body(pythagoreanValuesResponse);
    }
}
