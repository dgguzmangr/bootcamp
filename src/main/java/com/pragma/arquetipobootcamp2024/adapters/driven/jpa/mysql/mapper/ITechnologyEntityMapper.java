package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import  java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyEntityMapper {
    //@Mapping(source = "supplier.id", target = "supplier.id")
    //@Mapping(source = "supplier.name", target = "supplier.name")
    //@Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    Technology toModel(TechnologyEntity technologyEntity);
    //@Mapping(source = "supplier.id", target = "supplier.id")
    //@Mapping(source = "supplier.name", target = "supplier.name")
    //@Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    TechnologyEntity toEntity(Technology technology);
    List<Technology> toModelList(List<TechnologyEntity> technologyEntities);
}
