package org.example.domain.utils.Enum;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {
    ELECTRODOMESTICOS("Electrodomésticos"),
    CARNICOS("Cárnicos"),
    ROPA("Ropa"),
    ASEO("Aseo");

    private final String type;

    public String getType() {
        return type;
    }
}
