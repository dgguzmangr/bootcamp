package com.pragma.bootcamp.adapters.driving.http.mapper;

import com.pragma.bootcamp.adapters.driving.http.dto.response.TechCapResponse;
import com.pragma.bootcamp.domain.model.TechCap;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechCapResponseMapper {
    TechCapResponse toTechCapResponse(TechCap techCap);
    List<TechCapResponse> toTechCapResponseList(List<TechCap> techCapabilities);
}
