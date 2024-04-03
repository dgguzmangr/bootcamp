package com.pragma.bootcamp.domain.model;

import com.pragma.bootcamp.domain.exception.EmptyFieldException;
import com.pragma.bootcamp.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Bootcamp {
    private final Long id;
    private final String name;

    public Bootcamp(long id, String name) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
