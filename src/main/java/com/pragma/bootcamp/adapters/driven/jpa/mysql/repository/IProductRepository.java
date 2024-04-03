package com.pragma.bootcamp.adapters.driven.jpa.mysql.repository;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByNameContaining(String name);
    Optional<ProductEntity> findByName(String name);
    Page<ProductEntity> findAll(Pageable pageable);
    Page<ProductEntity> findAllBySupplierNameContaining(String supplier, Pageable pageable);
    Page<ProductEntity> findAllByQuantityLessThanEqual(Long quantity, Pageable pageable);
}
