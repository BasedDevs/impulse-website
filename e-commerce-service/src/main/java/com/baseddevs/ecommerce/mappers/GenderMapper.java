package com.baseddevs.mappers;

import com.baseddevs.dto.GenderDTO;
import com.baseddevs.model.Gender;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {

    public GenderDTO toDTO(Gender gender) {
        return new GenderDTO(
                gender.getId(),
                gender.getGender()
        );
    }
}