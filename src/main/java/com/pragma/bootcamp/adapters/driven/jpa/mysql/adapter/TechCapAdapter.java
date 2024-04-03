package com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.TechCapEntity;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.TechCapAlreadyExistsException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ITechCapEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ITechCapRepository;
import com.pragma.bootcamp.domain.model.TechCap;
import com.pragma.bootcamp.domain.spi.ITechCapPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.List;

@RequiredArgsConstructor
public class TechCapAdapter implements ITechCapPersistencePort {
    private final ITechCapRepository techCapRepository;
    private final ITechCapEntityMapper techCapEntityMapper;

    @Override
    public void saveTechCap(TechCap techCap) {
        if (techCapRepository.findByName(techCap.getName()).isPresent()) {
            throw new TechCapAlreadyExistsException();
        }
        /*
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
        */
        techCapRepository.save(techCapEntityMapper.toEntity(techCap));
    }

    @Override
    public TechCap getTechCap(String name) {
        Pageable pagination = PageRequest.of(0, 10);
        Page<TechCapEntity> page = techCapRepository.findByNameContaining(name, pagination);
        if (page.isEmpty()) {
            throw new ElementNotFoundException();
        }
        TechCapEntity techCap = page.getContent().get(0);
        return techCapEntityMapper.toModel(techCap);
    }

    @Override
    public List<TechCap> getAllTechCapabilities(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechCapEntity> techCapabilities = techCapRepository.findAll(pagination).getContent();
        if (techCapabilities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return techCapEntityMapper.toModelList(techCapabilities);
    }

    @Override
    public List<TechCap> getAllTechCapabilitiesByName(String name, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        Page<TechCapEntity> pageResult = techCapRepository.findByNameContaining(name, pagination);
        List<TechCapEntity> content = pageResult.getContent();
        if (content.isEmpty()) {
            throw new NoDataFoundException();
        }
        return techCapEntityMapper.toModelList(content);
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
    public TechCap updateTechCap(TechCap techCap) {
        if (techCapRepository.findById(techCap.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        /*
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
         */
        return techCapEntityMapper.toModel(techCapRepository.save(techCapEntityMapper.toEntity(techCap)));
    }

    @Override
    public void deleteTechCap(Long id) {
        if (techCapRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        techCapRepository.deleteById(id);
    }
}
