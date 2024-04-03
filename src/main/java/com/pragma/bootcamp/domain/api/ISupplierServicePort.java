package com.pragma.bootcamp.domain.api;

import com.pragma.bootcamp.domain.model.Supplier;

import java.util.List;

public interface ISupplierServicePort {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
}
