package com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.BootcampAlreadyExistsException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp.domain.model.Bootcamp;
import com.pragma.bootcamp.domain.model.Technology;
import com.pragma.bootcamp.domain.spi.IBootcampPersistencePort;
import com.pragma.bootcamp.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.List;

@RequiredArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

    @Override
    public void saveBootcamp(Bootcamp bootcamp) {
        if (bootcampRepository.findByName(bootcamp.getName()).isPresent()) {
            throw new BootcampAlreadyExistsException();
        }
        /*
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
        */
        bootcampRepository.save(bootcampEntityMapper.toEntity(bootcamp));
    }
    @Override
    public Bootcamp getBootcamp(String name) {
        Pageable pagination = PageRequest.of(0, 10);
        Page<BootcampEntity> page = bootcampRepository.findByNameContaining(name, pagination);
        if (page.isEmpty()) {
            throw new ElementNotFoundException();
        }
        BootcampEntity bootcamp = page.getContent().get(0);
        return bootcampEntityMapper.toModel(bootcamp);
    }

    @Override
    public List<Bootcamp> getAllBootcamps(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<BootcampEntity> bootcamps = bootcampRepository.findAll(pagination).getContent();
        if (bootcamps.isEmpty()) {
            throw new NoDataFoundException();
        }
        return bootcampEntityMapper.toModelList(bootcamps);
    }

    @Override
    public List<Bootcamp> getAllBootcampsByName(String name, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        Page<BootcampEntity> pageResult = bootcampRepository.findByNameContaining(name, pagination);
        List<BootcampEntity> content = pageResult.getContent();
        if (content.isEmpty()) {
            throw new NoDataFoundException();
        }
        return bootcampEntityMapper.toModelList(content);
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
    public Bootcamp updateBootcamp(Bootcamp bootcamp) {
        if (bootcampRepository.findById(bootcamp.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        /*
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
         */
        return bootcampEntityMapper.toModel(bootcampRepository.save(bootcampEntityMapper.toEntity(bootcamp)));
    }

    @Override
    public void deleteBootcamp(Long id) {
        if (bootcampRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        bootcampRepository.deleteById(id);
    }
}
