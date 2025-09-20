package com.phase_one.pythagorean.services;

import com.phase_one.pythagorean.dtos.PythagoreanValuesResponse;
import com.phase_one.pythagorean.entities.PythagoreanValues;
import com.phase_one.pythagorean.mappers.PythagoreanValuesMapper;
import com.phase_one.pythagorean.repositories.PythagoreanValuesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PythagoreanService {

    private final PythagoreanValuesRepository pythagoreanValuesRepository;
    private final PythagoreanValuesMapper pythagoreanValuesMapper;

    public PythagoreanValuesResponse calculatePythagoreanSides(Long value) {
        long squareRoot = (long)Math.sqrt(value);

        if (squareRoot * squareRoot != value) {
            return new PythagoreanValuesResponse();
        }

        PythagoreanValues pythagoreanValues = pythagoreanValuesRepository.findPythagoreanValuesByValue(value);

        if(pythagoreanValues != null) {
            return pythagoreanValuesMapper.toDto(pythagoreanValues);
        }

        return calculateLegs(squareRoot, value);
    }

    private PythagoreanValuesResponse calculateLegs(long c, long value) {
        long left = 1L;
        long right = (long)c-1;

        while(left <= right){
            long computed = (left * left) + (right * right);
            if(value == computed){
                PythagoreanValues pythagoreanValues =  PythagoreanValues.builder()
                        .a(left)
                        .b(right)
                        .c(c)
                        .value(value)
                        .average((left + right + c) / 3.0)
                        .build();

                pythagoreanValuesRepository.save(pythagoreanValues);
                return pythagoreanValuesMapper.toDto(pythagoreanValues);
            }

            if(computed > value){
                right--;
            } else {
                left++;
            }
        }
        return new PythagoreanValuesResponse();
    }
}
