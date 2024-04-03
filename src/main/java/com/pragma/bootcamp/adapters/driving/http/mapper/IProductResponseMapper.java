package com.pragma.bootcamp.adapters.driving.http.mapper;

import com.pragma.bootcamp.adapters.driving.http.dto.response.ProductResponse;
import com.pragma.bootcamp.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductResponseMapper {
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.name", target = "supplier")
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponseList(List<Product> products);
}
