package com.pragma.bootcamp.configuration;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter.BootcampAdapter;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter.TechCapAdapter;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter.ProductAdapter;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.adapter.SupplierAdapter;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ITechCapEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.IProductEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ITechCapRepository;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.IProductRepository;
import com.pragma.bootcamp.adapters.driven.jpa.mysql.repository.ISupplierRepository;
import com.pragma.bootcamp.domain.api.IBootcampServicePort;
import com.pragma.bootcamp.domain.api.ITechCapServicePort;
import com.pragma.bootcamp.domain.api.ITechnologyServicePort;
import com.pragma.bootcamp.domain.api.IProductServicePort;
import com.pragma.bootcamp.domain.api.ISupplierServicePort;
import com.pragma.bootcamp.domain.api.usecase.BootcampUseCase;
import com.pragma.bootcamp.domain.api.usecase.TechCapUseCase;
import com.pragma.bootcamp.domain.api.usecase.TechnologyUseCase;
import com.pragma.bootcamp.domain.api.usecase.ProductUseCase;
import com.pragma.bootcamp.domain.api.usecase.SupplierUseCase;
import com.pragma.bootcamp.domain.spi.IBootcampPersistencePort;
import com.pragma.bootcamp.domain.spi.ITechCapPersistencePort;
import com.pragma.bootcamp.domain.spi.ITechnologyPersistencePort;
import com.pragma.bootcamp.domain.spi.IProductPersistencePort;
import com.pragma.bootcamp.domain.spi.ISupplierPersistencePort;
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
    private final ITechCapRepository techCapRepository;
    private final ITechCapEntityMapper techCapEntityMapper;
    private final IBootcampRepository bootcampCapRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

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

    @Bean
    ITechCapPersistencePort techCapPersistencePort() {
        return  new TechCapAdapter(techCapRepository, techCapEntityMapper);
    };
    @Bean
    public ITechCapServicePort techCapServicePort() { return new TechCapUseCase(techCapPersistencePort()); }


    @Bean
    IBootcampPersistencePort bootcampPersistencePort() {
        return  new BootcampAdapter(bootcampCapRepository, bootcampEntityMapper);
    };
    @Bean
    public IBootcampServicePort bootcampServicePort() { return new BootcampUseCase(bootcampPersistencePort()); }

}
