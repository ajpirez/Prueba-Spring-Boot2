package org.example.service.User;

import org.example.domain.Auth.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);

    List<User> getUsers();

    void deleteUser(Long id);
}
