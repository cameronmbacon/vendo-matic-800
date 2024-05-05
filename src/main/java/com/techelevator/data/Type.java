package com.techelevator.data;

public enum Type {
    CHIP("Chip"),
    CANDY("Candy"),
    DRINK("Drink"),
    GUM("Gum");

    private final String productType;

    Type(String productType) {this.productType = productType;}

    public String getProductType() {return productType;}

    public static Type fromString(String typeString) {
        for (Type type : Type.values()) {
            if (type.name().equalsIgnoreCase(typeString)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unsupported item type: " + typeString);
    }
}
