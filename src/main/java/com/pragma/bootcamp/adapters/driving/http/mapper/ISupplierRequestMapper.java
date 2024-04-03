package com.pragma.bootcamp.adapters.driving.http.mapper;

import com.pragma.bootcamp.adapters.driving.http.dto.request.AddSupplierRequest;
import com.pragma.bootcamp.domain.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplierRequestMapper {
    @Mapping(target = "id", ignore = true)
    Supplier addRequestToSupplier(AddSupplierRequest addSupplierRequest);
}
