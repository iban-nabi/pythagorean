package com.phase_one.pythagorean.mappers;

import com.phase_one.pythagorean.dtos.PythagoreanValuesResponse;
import com.phase_one.pythagorean.entities.PythagoreanValues;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PythagoreanValuesMapper {
    PythagoreanValuesResponse toDto(PythagoreanValues pythagoreanValues);
}

