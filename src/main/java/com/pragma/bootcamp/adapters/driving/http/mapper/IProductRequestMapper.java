package com.pragma.bootcamp.adapters.driving.http.mapper;

import com.pragma.bootcamp.adapters.driving.http.dto.request.AddProductRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.request.UpdateProductRequest;
import com.pragma.bootcamp.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProductRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(target = "supplier.name", constant = "name")
    @Mapping(target = "supplier.contactNumber", constant = "number")
    Product addRequestToProduct(AddProductRequest addProductRequest);
    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(target = "supplier.name", constant = "name")
    @Mapping(target = "supplier.contactNumber", constant = "number")
    Product updateRequestToProduct(UpdateProductRequest updateProductRequest);
}
