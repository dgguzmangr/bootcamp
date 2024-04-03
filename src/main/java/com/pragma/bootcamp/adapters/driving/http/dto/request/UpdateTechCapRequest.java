package com.pragma.bootcamp.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateTechCapRequest {
    private final Long id;
    private final String name;
    private final String description;
}
