package com.jie.pythagorean.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@Table(name = "pythagorean_values")
@NoArgsConstructor
@AllArgsConstructor
public class PythagoreanValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "a")
    private Long a;

    @Column(name = "b")
    private Long b;

    @Column(name = "c")
    private Long c;

    @Column(name = "value", unique = true)
    private Long value;

    @Column(name = "average")
    private Double average;
}
