package com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.TechCapEntity;
import com.pragma.bootcamp.domain.model.TechCap;
import org.mapstruct.Mapper;

import  java.util.List;

@Mapper(componentModel = "spring")
public interface ITechCapEntityMapper {
    //@Mapping(source = "supplier.id", target = "supplier.id")
    //@Mapping(source = "supplier.name", target = "supplier.name")
    //@Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    TechCap toModel(TechCapEntity techCapEntity);
    //@Mapping(source = "supplier.id", target = "supplier.id")
    //@Mapping(source = "supplier.name", target = "supplier.name")
    //@Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    TechCapEntity toEntity(TechCap techCap);
    List<TechCap> toModelList(List<TechCapEntity> techCapEntities);
}
