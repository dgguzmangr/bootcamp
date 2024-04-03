package com.pragma.bootcamp.domain.api.usecase;

import com.pragma.bootcamp.domain.api.ITechCapServicePort;
import com.pragma.bootcamp.domain.model.TechCap;
import com.pragma.bootcamp.domain.spi.ITechCapPersistencePort;

import java.util.List;

public class TechCapUseCase implements ITechCapServicePort {
    private ITechCapPersistencePort techCapPersistencePort;

    public TechCapUseCase(ITechCapPersistencePort technologyPersistencePort) {
        this.techCapPersistencePort = techCapPersistencePort;
    }

    @Override
    public void saveTechCap(TechCap techCap) {
        techCapPersistencePort.saveTechCap(techCap);
    }

    @Override
    public TechCap getTechCap(String name) {
        return techCapPersistencePort.getTechCap(name);
    }

    @Override
    public List<TechCap> getAllTechCapabilities(Integer page, Integer size) {
        return techCapPersistencePort.getAllTechCapabilities(page, size);
    }

    @Override
    public List<TechCap> getAllTechCapabilitiesByName(String name, Integer page, Integer size) {
        return techCapPersistencePort.getAllTechCapabilitiesByName(name, page, size);
    }

    @Override
    public TechCap updateTechCap(TechCap techCap) {
        return techCapPersistencePort.updateTechCap(techCap);
    }

    @Override
    public void deleteTechCap(Long id) {
        techCapPersistencePort.deleteTechCap(id);
    }
}
