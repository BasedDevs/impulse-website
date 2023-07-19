package com.baseddevs.service;

import com.baseddevs.dto.InventoryDTO;

public interface InventoryService {

    InventoryDTO getInventoryById(Long inventoryId);

    InventoryDTO updateInventoryById(Long inventoryId, InventoryDTO inventory);

    void deleteInventoryById(Long inventoryId);
}
