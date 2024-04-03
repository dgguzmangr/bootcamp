package com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.ProductEntity;
import com.pragma.bootcamp.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductEntityMapper {
    @Mapping(source = "supplier.id", target = "supplier.id")
    @Mapping(source = "supplier.name", target = "supplier.name")
    @Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    Product toModel(ProductEntity productEntity);
    @Mapping(source = "supplier.id", target = "supplier.id")
    @Mapping(source = "supplier.name", target = "supplier.name")
    @Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    ProductEntity toEntity(Product product);
    List<Product> toModelList(List<ProductEntity> productEntities);
}
