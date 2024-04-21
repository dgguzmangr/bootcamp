package com.pragma.bootcamp.domain.model;

import com.pragma.bootcamp.domain.exception.EmptyFieldException;
import com.pragma.bootcamp.domain.exception.MaxNameCharactersException;
import com.pragma.bootcamp.domain.exception.MaxDescCharactersException;
import com.pragma.bootcamp.domain.exception.DuplicateFieldException;
import com.pragma.bootcamp.domain.util.DomainConstants;

import java.util.HashSet;
import static java.util.Objects.requireNonNull;
import java.util.Set;

public class Technology {
    private final Long id;
    private final String name;
    private final String description;
    private static final Set<String> existingNames = new HashSet<>();


    public Technology(long id, String name, String description) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (name.length() > 50) {
            throw new MaxNameCharactersException(DomainConstants.Field.NAME.toString());
        }
        if (existingNames.contains(name)) {
            throw new DuplicateFieldException(DomainConstants.FIELD_NAME_DUPLICATE_MESSAGE);
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if (description.length() > 90) {
            throw new MaxDescCharactersException(DomainConstants.Field.DESCRIPTION.toString());
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        existingNames.add(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
