package com.pragma.bootcamp.domain.api.usecase;

import com.pragma.bootcamp.domain.api.ISupplierServicePort;
import com.pragma.bootcamp.domain.model.Supplier;
import com.pragma.bootcamp.domain.spi.ISupplierPersistencePort;

import java.util.List;

public class SupplierUseCase implements ISupplierServicePort {
    private final ISupplierPersistencePort supplierPersistencePort;

    public SupplierUseCase(ISupplierPersistencePort supplierPersistencePort) {
        this.supplierPersistencePort = supplierPersistencePort;
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierPersistencePort.addSupplier(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierPersistencePort.getAllSuppliers();
    }
}
