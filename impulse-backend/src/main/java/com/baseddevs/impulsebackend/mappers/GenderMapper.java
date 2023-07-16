package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.GenderDTO;
import com.baseddevs.impulsebackend.model.Gender;
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