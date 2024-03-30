package com.pragma.arquetipobootcamp2024.configuration;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.ProductAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.SupplierAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.IProductEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.IProductRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ISupplierRepository;
import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.IProductServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.ISupplierServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.TechnologyUseCase;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.ProductUseCase;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.SupplierUseCase;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.spi.IProductPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.spi.ISupplierPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;
    private final ISupplierRepository supplierRepository;
    private final ISupplierEntityMapper supplierEntityMapper;
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Bean
    public IProductPersistencePort productPersistencePort() {
        return new ProductAdapter(productRepository, productEntityMapper, supplierRepository, supplierEntityMapper);
    }
    @Bean
    public IProductServicePort productServicePort() {
        return new ProductUseCase(productPersistencePort());
    }
    @Bean
    public ISupplierPersistencePort supplierPersistencePort() {
        return new SupplierAdapter(supplierRepository, supplierEntityMapper);
    }
    @Bean
    public ISupplierServicePort supplierServicePort() {
        return new SupplierUseCase(supplierPersistencePort());
    }


    @Bean
    ITechnologyPersistencePort technologyPersistencePort() {
        return  new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    };
    @Bean
    public ITechnologyServicePort technologyServicePort() { return new TechnologyUseCase(technologyPersistencePort()); }
}
