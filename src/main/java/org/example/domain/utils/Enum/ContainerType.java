package org.example.domain.utils.Enum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public enum ContainerType { //Bien por el enum, es asi, haz uno para los Roles tambien
    CARTON("Cartón"),
    PLASTICO("Plástico"),
    CRISTAL("Cristal"),
    NYLON("Nylon");

    private final String type;

    public String getType() {
        return type;
    }
}
