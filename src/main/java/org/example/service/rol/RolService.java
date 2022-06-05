package org.example.service.rol;

import org.example.domain.auth.Rol;
import org.example.domain.utils.Enum.RolType;

import java.util.List;

public interface RolService {

    List<Rol> getRoles();

    Rol saveRol(Rol rol);

    void addRoleToUser(String username, String rolName);
}
