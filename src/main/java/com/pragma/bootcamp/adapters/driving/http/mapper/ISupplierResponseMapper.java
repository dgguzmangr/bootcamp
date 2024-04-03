package com.pragma.bootcamp.adapters.driving.http.mapper;

import com.pragma.bootcamp.adapters.driving.http.dto.response.SupplierResponse;
import com.pragma.bootcamp.domain.model.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISupplierResponseMapper {
    SupplierResponse toSupplierResponse(Supplier supplier);
    List<SupplierResponse> toSupplierResponseList(List<Supplier> suppliers);
}
