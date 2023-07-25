package com.baseddevs.userservice.repository;

import com.baseddevs.userservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
