package com.pragma.bootcamp.domain.spi;

import com.pragma.bootcamp.domain.model.Technology;

import  java.util.List;

public interface ITechnologyPersistencePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(Integer page, Integer size);
    List<Technology> getAllTechnologiesByName(String name, Integer page, Integer size);
    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}