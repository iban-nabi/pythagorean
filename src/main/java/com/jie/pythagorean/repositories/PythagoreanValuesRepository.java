package com.jie.pythagorean.repositories;

import com.jie.pythagorean.entities.PythagoreanValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PythagoreanValuesRepository extends JpaRepository<PythagoreanValues, Long> {
    PythagoreanValues findPythagoreanValuesByValue(Long input);
}
