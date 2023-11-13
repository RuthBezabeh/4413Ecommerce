package com.ecommerce.PaymentServices.htmlclasses;


import com.ecommerce.PaymentServices.htmlclasses.FieldType;

public class FieldDefinition {
    private String name;
    private String label;
    private FieldType type;

    public FieldDefinition(String name, String label, FieldType type) {
        this.name = name;
        this.label = label;
        this.type = type;
    }

        // Getters and setters

}
