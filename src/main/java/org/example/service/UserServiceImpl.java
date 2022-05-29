package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Rol;
//import org.example.domain.User;
import org.example.domain.User;
import org.example.repo.RolRepo;
import org.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RolRepo rolRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Rol saveRol(Rol rol) {
        log.info("Saving new role {} to the database", rol.getName());
        return rolRepo.save(rol);
    }

    @Override
    public void addRoleToUser(String username, String rolName) {
        log.info("Adding role {} to user {}", rolName, username);
        User user = userRepo.findByUsername(username);
        Rol rol = rolRepo.findByName(rolName);
        user.getRoles().add(rol);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
//        log.info("Fetching all user");
        return userRepo.findAll();
    }
}
