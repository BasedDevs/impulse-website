package com.baseddevs.ecommerce.service.impl;

import com.baseddevs.ecommerce.dto.InventoryDTO;
import com.baseddevs.ecommerce.exception.utils.ExceptionUtils;
import com.baseddevs.ecommerce.mapper.InventoryMapper;
import com.baseddevs.ecommerce.repository.InventoryRepository;
import com.baseddevs.ecommerce.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    private final ExceptionUtils exceptionUtils;

    @Override
    public InventoryDTO create(InventoryDTO inventoryDTO) {
        return null;
    }

    @Override
    public InventoryDTO getById(Long id) {
        return null;
    }

    @Override
    public InventoryDTO update(Long id, InventoryDTO inventoryDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<InventoryDTO> getAll() {
        return null;
    }
}