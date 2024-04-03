package com.pragma.bootcamp.domain.api;

import com.pragma.bootcamp.domain.model.TechCap;

import java.util.List;
public interface ITechCapServicePort {
    void saveTechCap(TechCap techCap);
    TechCap getTechCap(String name);
    List<TechCap> getAllTechCapabilities(Integer page, Integer size);
    List<TechCap> getAllTechCapabilitiesByName(String name, Integer page, Integer size);
    TechCap updateTechCap(TechCap techCap);
    void deleteTechCap(Long id);
}
