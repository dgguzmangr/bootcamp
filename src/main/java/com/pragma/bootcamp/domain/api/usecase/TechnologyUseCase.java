package com.pragma.bootcamp.domain.api.usecase;

import com.pragma.bootcamp.domain.api.ITechnologyServicePort;
import com.pragma.bootcamp.domain.model.Technology;
import com.pragma.bootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {
    private ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology) {
        technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String name) {
        return technologyPersistencePort.getTechnology(name);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, boolean ascendingOrder) {
        return technologyPersistencePort.getAllTechnologies(page, size, ascendingOrder);
    }

    @Override
    public List<Technology> getAllTechnologiesByName(String name, Integer page, Integer size, boolean ascendingOrder) {
        return technologyPersistencePort.getAllTechnologiesByName(name, page, size, ascendingOrder);
    }


    @Override
    public Technology updateTechnology(Technology technology) {
        return technologyPersistencePort.updateTechnology(technology);
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyPersistencePort.deleteTechnology(id);
    }
}

