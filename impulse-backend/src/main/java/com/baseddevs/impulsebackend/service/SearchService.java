package com.baseddevs.impulsebackend.service;

import com.baseddevs.impulsebackend.dto.ProductDTO;

import java.util.List;

public interface SearchService {

    List<ProductDTO> searchProducts(String query);

}
