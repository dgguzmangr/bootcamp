package com.pragma.bootcamp.domain.spi;

import com.pragma.bootcamp.domain.model.Bootcamp;

import java.util.List;

public interface IBootcampPersistencePort {
    void saveBootcamp(Bootcamp bootcamp);
    Bootcamp getBootcamp(String name);
    List<Bootcamp> getAllBootcamps(Integer page, Integer size);
    List<Bootcamp> getAllBootcampsByName(String name, Integer page, Integer size);
    Bootcamp updateBootcamp(Bootcamp bootcamp);
    void deleteBootcamp(Long id);
}
