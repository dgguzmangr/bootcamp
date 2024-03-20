package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Bootcamp;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IBootcampServicePort {
    void saveBootcamp(Bootcamp bootcamp);
    Bootcamp getBootcamp(String name);
    List<Bootcamp> getAllBootcamps(Integer page, Integer size);
    List<Bootcamp> getAllBootcampsBySupplier(String supplier, Integer page, Integer size);
    Bootcamp updateBootcamp(Bootcamp bootcamp);
    void deleteBootcamp(Long id);
}
