package com.baseddevs.ecommerce.service;

import com.baseddevs.ecommerce.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO create(InventoryDTO inventoryDTO);

    InventoryDTO getById(Long id);

    InventoryDTO update(Long id, InventoryDTO inventoryDTO);

    void delete(Long id);

    List<InventoryDTO> getAll();
}