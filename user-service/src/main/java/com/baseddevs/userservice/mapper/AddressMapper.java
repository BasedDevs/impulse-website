package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.user.AddressDTO;
import com.baseddevs.userservice.model.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressMapper {

    public AddressDTO toDTO(Address address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getCity(), address.getState(), address.getZipCode(), address.getCountry());
    }
}
