package com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.pragma.bootcamp.domain.model.Bootcamp;
import org.mapstruct.Mapper;

import  java.util.List;

@Mapper(componentModel = "spring")
public interface IBootcampEntityMapper {
    //@Mapping(source = "supplier.id", target = "supplier.id")
    //@Mapping(source = "supplier.name", target = "supplier.name")
    //@Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    Bootcamp toModel(BootcampEntity bootcampEntity);
    //@Mapping(source = "supplier.id", target = "supplier.id")
    //@Mapping(source = "supplier.name", target = "supplier.name")
    //@Mapping(source = "supplier.contactNumber", target = "supplier.contactNumber")
    BootcampEntity toEntity(Bootcamp bootcamp);
    List<Bootcamp> toModelList(List<BootcampEntity> bootcampEntities);
}
