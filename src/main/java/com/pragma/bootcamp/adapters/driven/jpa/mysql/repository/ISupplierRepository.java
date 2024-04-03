package com.pragma.bootcamp.adapters.driven.jpa.mysql.repository;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Optional<SupplierEntity> findByName(String name);
}
