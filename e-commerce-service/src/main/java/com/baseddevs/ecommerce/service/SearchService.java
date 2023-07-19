package com.baseddevs.service;

import com.baseddevs.dto.ProductDTO;

import java.util.List;

public interface SearchService {

    List<ProductDTO> searchProducts(String query);

}
