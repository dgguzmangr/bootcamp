package com.pragma.bootcamp.adapters.driven.jpa.mysql.repository;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.TechCapEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ITechCapRepository extends JpaRepository<TechCapEntity, Long> {
    Page<TechCapEntity> findByNameContaining(String name, Pageable pageable);
    Optional<TechCapEntity> findByName(String name);
    Page<TechCapEntity> findAll(Pageable pageable);
    //Page<TechnologyEntity> findAllByQuantityLessThanEqual(Long quantity, Pageable pageable);
}
