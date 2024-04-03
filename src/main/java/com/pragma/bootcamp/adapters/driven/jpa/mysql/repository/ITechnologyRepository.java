package com.pragma.bootcamp.adapters.driven.jpa.mysql.repository;

import com.pragma.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {
    Page<TechnologyEntity> findByNameContaining(String name, Pageable pageable);
    Optional<TechnologyEntity> findByName(String name);
    Page<TechnologyEntity> findAll(Pageable pageable);
    //Page<TechnologyEntity> findAllByQuantityLessThanEqual(Long quantity, Pageable pageable);
}
