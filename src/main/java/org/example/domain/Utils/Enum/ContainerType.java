package org.example.domain.Utils.Enum;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

public enum ContainerType { //Bien por el enum, es asi, haz uno para los Roles tambien
    CARTON("Cartón"),
    PLASTICO("Plástico"),
    CRISTAL("Cristal"),
    NYLON("Nylon");

    private final String type;

    ContainerType(String containerType) {

        this.type = containerType;

    }

    public String getType() {

        return this.type;
    }

//    public ContainerType getByName(String name) {
//        for (ContainerType type : ContainerType.values()) {
//            if (type.getType().equals(name)) {
//                return type;
//            }
//        }
//        return null;
//    }
}
