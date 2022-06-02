package org.example.domain.Utils.Enum;

public enum ProductType {
    ELECTRODOMESTICOS("Electrodomésticos"),
    CARNICOS("Cárnicos"),
    ROPA("Ropa"),
    ASEO("Aseo");

    private final String type;

    ProductType(String productType) {
        this.type = productType;
    }

    public String getType() {

        return this.type;
    }
}
