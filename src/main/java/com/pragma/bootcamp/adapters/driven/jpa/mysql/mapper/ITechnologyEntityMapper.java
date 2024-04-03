package com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.bootcamp.domain.model.Technology;
import org.mapstruct.Mapper;

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
