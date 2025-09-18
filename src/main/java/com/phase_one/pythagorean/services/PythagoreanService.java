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
        double squareRoot = Math.sqrt(value);

        if (squareRoot != Math.floor(squareRoot)) {
            return new PythagoreanValuesResponse();
        }

        PythagoreanValues pythagoreanValues = pythagoreanValuesRepository.findPythagoreanValuesByValue(value);

        if(pythagoreanValues != null) {
            System.out.println("Im in the db");
            return pythagoreanValuesMapper.toDto(pythagoreanValues);
        }

        //create if statement if value exist in database and retrieve it if it exist

        return calculateLegs(squareRoot, value);
    }

    private PythagoreanValuesResponse calculateLegs(double c, long cSquared) {
        long left = 1L;
        long right = (long)c - 1;

        while(left < right){
            long computed = (left * left) + (right * right);
            if(cSquared == computed){
                System.out.println("SUCCESS");
                PythagoreanValues pythagoreanValues =  PythagoreanValues.builder()
                        .a(left)
                        .b(right)
                        .c((long)c)
                        .value(cSquared)
                        .average((left + right + c) / 3.0)
                        .build();

                pythagoreanValuesRepository.save(pythagoreanValues);
                return pythagoreanValuesMapper.toDto(pythagoreanValues);
            }

            if(computed > cSquared){
                right--;
            } else {
                left++;
            }
        }
        System.out.println("NOT SUCCESS");
        return new PythagoreanValuesResponse();
    }

}
