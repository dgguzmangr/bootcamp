package com.pragma.bootcamp.adapters.driving.http.mapper;


import com.pragma.bootcamp.adapters.driving.http.dto.request.AddTechCapRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.request.UpdateTechCapRequest;
import com.pragma.bootcamp.domain.model.TechCap;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITechCapRequestMapper {
    @Mapping(target = "id", ignore = true)
    TechCap addRequestToTechCap(AddTechCapRequest addTechCapRequest);
    TechCap updateRequestToTechCap(UpdateTechCapRequest updateTechCapRequest);
}
