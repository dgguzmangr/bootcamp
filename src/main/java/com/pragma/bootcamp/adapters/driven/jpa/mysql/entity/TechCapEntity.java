package com.pragma.bootcamp.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "techcap")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TechCapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    //@ManyToOne
    //@JoinColumn(name = "id_tech_cap")
    //private TechCapEntity TechCap;
    //private SupplierEntity supplier;
}
