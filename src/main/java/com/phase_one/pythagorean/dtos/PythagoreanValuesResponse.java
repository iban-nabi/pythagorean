package com.phase_one.pythagorean.dtos;

import lombok.*;

@Getter
@Setter
public class PythagoreanValuesResponse {
    private Long id;
    private Long a;
    private Long b;
    private Long c;
    private Long value;
    private Double average;
}
