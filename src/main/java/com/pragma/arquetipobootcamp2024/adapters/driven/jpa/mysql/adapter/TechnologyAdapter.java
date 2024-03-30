package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.configuration.Constants;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public void saveTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException();
        }
        /*
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
        */
        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }

    @Override
    public Technology getTechnology(String name) {
        Pageable pagination = PageRequest.of(0, 10);
        TechnologyEntity technology = technologyRepository.findByNameContaining(name, pagination).orElseThrow(ElementNotFoundException::new);
        return technologyEntityMapper.toModel(technology);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechnologyEntity> technologies = technologyRepository.findAll(pagination).getContent();
        if (technologies.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(technologies);
    }

    @Override
    public List<Technology> getAllTechnologiesByName(String name, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        Optional<TechnologyEntity> optionalTechnology = technologyRepository.findByNameContaining(name, pagination);
        if (optionalTechnology.isEmpty()) {
            throw new NoDataFoundException();
        }
        TechnologyEntity technology = optionalTechnology.get();
        return List.of(technologyEntityMapper.toModel(technology));
    }

    /*
    @Override
    public List<T> getAllProductsBySupplier(String supplier, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<ProductEntity> products = productRepository.findAllBySupplierNameContaining(supplier, pagination).getContent();
        if (products.isEmpty()) {
            throw new NoDataFoundException();
        }
        return productEntityMapper.toModelList(products);
    }

    @Override
    public List<Product> getAllSoldOutProducts(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<ProductEntity> products = productRepository.findAllByQuantityLessThanEqual(
                Constants.SOLD_OUT_VALUE, pagination).getContent();
        if (products.isEmpty()) {
            throw new NoDataFoundException();
        }
        return productEntityMapper.toModelList(products);
    }
    */

    @Override
    public Technology updateTechnology(Technology technology) {
        if (technologyRepository.findById(technology.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        /*
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
         */
        return technologyEntityMapper.toModel(technologyRepository.save(technologyEntityMapper.toEntity(technology)));
    }

    @Override
    public void deleteTechnology(Long id) {
        if (technologyRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        technologyRepository.deleteById(id);
    }
}
