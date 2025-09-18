package com.phase_one.pythagorean.repositories;

import com.phase_one.pythagorean.entities.PythagoreanValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PythagoreanValuesRepository extends JpaRepository<PythagoreanValues, Long> {
    PythagoreanValues findPythagoreanValuesByValue(Long input);
}
