package com.pragma.bootcamp.domain.spi;

import com.pragma.bootcamp.domain.model.Supplier;

import java.util.List;

public interface ISupplierPersistencePort {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
}
