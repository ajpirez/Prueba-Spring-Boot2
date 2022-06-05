package org.example.service.user;

import org.example.domain.auth.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);

    List<User> getUsers();

    void deleteUser(Long id);
}
