package com.baseddevs.mappers;

import com.baseddevs.dto.InventoryDTO;
import com.baseddevs.model.Inventory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventoryMapper {

    private final ProductVariantMapper productVariantMapper;

    public InventoryDTO toDTO(Inventory inventory) {
        return new InventoryDTO(
                inventory.getId(),
                productVariantMapper.toDTO(inventory.getVariant()),
                inventory.getQuantity()
        );
    }
}