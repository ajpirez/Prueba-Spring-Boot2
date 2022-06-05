package org.example.domain.utils.Enum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public enum RolType { //Bien por el enum, es asi, haz uno para los Roles tambien
    ADMINISTRATOR("ROLE_ADMIN"),
    OPERATOR("ROLE_OPERATOR");

    private final String type;

    public String getType() {
        return type;
    }
    }
