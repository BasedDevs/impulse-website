package com.baseddevs.impulsebackend.mappers;

import com.baseddevs.impulsebackend.dto.InventoryDTO;
import com.baseddevs.impulsebackend.model.Inventory;
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