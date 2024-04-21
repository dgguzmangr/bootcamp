package com.pragma.bootcamp.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION,
        PRICE,
        QUANTITY,
        CONTACTNUMBER
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_NAME_DUPLICATE_MESSAGE = "Field 'name' must be unique";
    public  static final  String FIELD_NAME_MAX_CHARACTERS_MESSAGE = "Field 'name' must have at most 50 characters";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public  static final  String FIELD_DESCRIPTION_MAX_CHARACTERS_MESSAGE = "Field 'description' must have at most 90 characters";
    public static final String FIELD_PRICE_NULL_MESSAGE = "Field 'price' cannot be null";
    public static final String FIELD_QUANTITY_NULL_MESSAGE = "Field 'quantity' cannot be null";
    public static final String FIELD_SUPPLIER_NULL_MESSAGE = "Field 'supplier' cannot be null";
    public static final String FIELD_CONTACT_NUMBER_NULL_MESSAGE = "Field 'contact number' cannot be null";
}
