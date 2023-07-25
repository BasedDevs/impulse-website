package com.baseddevs.ecommerce.mapper;

import com.baseddevs.ecommerce.dto.InventoryDTO;
import com.baseddevs.ecommerce.model.Inventory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventoryMapper {

    private final ProductVariantMapper productVariantMapper;

    public InventoryDTO toDTO(Inventory inventory) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setVariant(productVariantMapper.toDTO(inventory.getVariant()));
        inventoryDTO.setQuantity(inventory.getQuantity());
        inventoryDTO.setSku(inventory.getSku());
        return inventoryDTO;
    }

}
