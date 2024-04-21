package com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp.domain.model.Technology;
import com.pragma.bootcamp.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.List;

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
        Page<TechnologyEntity> page = technologyRepository.findByNameContaining(name, pagination);
        if (page.isEmpty()) {
            throw new ElementNotFoundException();
        }
        TechnologyEntity technology = page.getContent().get(0);
        return technologyEntityMapper.toModel(technology);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, boolean ascendingOrder) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechnologyEntity> technologies = technologyRepository.findAll(pagination).getContent();
        if (technologies.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(technologies);
    }

    @Override
    public List<Technology> getAllTechnologiesByName(String name, Integer page, Integer size, boolean ascendingOrder) {
        Pageable pagination = PageRequest.of(page, size);
        Page<TechnologyEntity> pageResult = technologyRepository.findByNameContaining(name, pagination);
        List<TechnologyEntity> content = pageResult.getContent();
        if (content.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(content);
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
