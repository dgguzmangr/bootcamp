package com.pragma.bootcamp.domain.api.usecase;

import com.pragma.bootcamp.domain.api.IBootcampServicePort;
import com.pragma.bootcamp.domain.model.Bootcamp;
import com.pragma.bootcamp.domain.spi.IBootcampPersistencePort;

import java.util.List;

public class BootcampUseCase  implements IBootcampServicePort {
    private IBootcampPersistencePort bootcampPersistencePort;

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
    }
    @Override
    public void saveBootcamp(Bootcamp bootcamp) {
        bootcampPersistencePort.saveBootcamp(bootcamp);
    }

    @Override
    public Bootcamp getBootcamp(String name) {
        return bootcampPersistencePort.getBootcamp(name);
    }

    @Override
    public List<Bootcamp> getAllBootcamps(Integer page, Integer size) {
        return bootcampPersistencePort.getAllBootcamps(page, size);
    }

    @Override
    public List<Bootcamp> getAllBootcampsByName(String name, Integer page, Integer size) {
        return bootcampPersistencePort.getAllBootcampsByName(name, page, size);
    }

    @Override
    public Bootcamp updateBootcamp(Bootcamp bootcamp) {
        return bootcampPersistencePort.updateBootcamp(bootcamp);
    }

    @Override
    public void deleteBootcamp(Long id) {
        bootcampPersistencePort.deleteBootcamp(id);
    }
}
