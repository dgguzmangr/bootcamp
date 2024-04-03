package com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.SupplierEntity;
import com.pragma.bootcamp.domain.model.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISupplierEntityMapper {
    Supplier toModel(SupplierEntity supplierEntity);
    SupplierEntity toEntity(Supplier supplier);
    List<Supplier> toModelList(List<SupplierEntity> supplierEntities);
}
