package com.phase_one.pythagorean.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long a;
    private Long b;
    private Long c;
    private Double average;

}
