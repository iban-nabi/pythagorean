package com.jie.pythagorean.mappers;

import com.jie.pythagorean.dtos.PythagoreanValuesResponse;
import com.jie.pythagorean.entities.PythagoreanValues;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PythagoreanValuesMapper {
    PythagoreanValuesResponse toDto(PythagoreanValues pythagoreanValues);
}

