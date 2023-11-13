package com.ecommerce.PaymentServices;


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
