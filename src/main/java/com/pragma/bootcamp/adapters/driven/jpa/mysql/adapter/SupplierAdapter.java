package com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.SupplierEntity;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.exception.SupplierAlreadyExistsException;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ISupplierRepository;
import com.pragma.bootcamp.domain.model.Supplier;
import com.pragma.bootcamp.domain.spi.ISupplierPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SupplierAdapter implements ISupplierPersistencePort {
    private final ISupplierRepository supplierRepository;
    private final ISupplierEntityMapper supplierEntityMapper;

    @Override
    public void addSupplier(Supplier supplier) {
        if (supplierRepository.findByName(supplier.getName()).isPresent()) {
            throw new SupplierAlreadyExistsException();
        }
        supplierRepository.save(supplierEntityMapper.toEntity(supplier));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<SupplierEntity> suppliers = supplierRepository.findAll();
        if (suppliers.isEmpty()) {
            throw new NoDataFoundException();
        }
        return supplierEntityMapper.toModelList(suppliers);
    }
}
