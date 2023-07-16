package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.InventoryDTO;

public interface InventoryService {

    InventoryDTO getInventoryById(Long inventoryId);

    InventoryDTO updateInventoryById(Long inventoryId, InventoryDTO inventory);

    void deleteInventoryById(Long inventoryId);
}
