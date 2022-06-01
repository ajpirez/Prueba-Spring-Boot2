package org.example.service.Rol;

import org.example.domain.Rol;

import java.util.List;

public interface RolService {

    List<Rol> getRoles();

    Rol saveRol(Rol rol);

    void addRoleToUser(String username, String rolName);
}
