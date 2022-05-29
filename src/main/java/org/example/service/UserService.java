package org.example.service;

import org.example.domain.Rol;
import org.example.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Rol saveRol(Rol rol);

    void addRoleToUser(String username, String rolName);

    User getUser(String username);

    List<User> getUsers();
}
