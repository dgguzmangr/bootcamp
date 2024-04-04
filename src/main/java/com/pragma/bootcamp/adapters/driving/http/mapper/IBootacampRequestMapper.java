package com.pragma.bootcamp.adapters.driving.http.mapper;

import com.pragma.bootcamp.adapters.driving.http.dto.request.AddBootcampRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.request.UpdateBootcampRequest;
import com.pragma.bootcamp.domain.model.Bootcamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBootacampRequestMapper {
    Bootcamp addRequestToBootcamp(AddBootcampRequest addBootcampRequest);
    Bootcamp updateRequestToBootcamp(UpdateBootcampRequest updateTechnologyRequest);
}
