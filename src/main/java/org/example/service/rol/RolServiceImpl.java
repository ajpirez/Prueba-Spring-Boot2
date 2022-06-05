package org.example.service.rol;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.auth.Rol;
import org.example.domain.auth.User;
import org.example.domain.utils.Enum.RolType;
import org.example.repo.auth.RolRepo;
import org.example.repo.auth.UserRepo;//
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j// Cambiar a Log4j2, cuanto antes mejor, que despues cuesta mas cambiar
public class RolServiceImpl implements RolService {

    private final UserRepo userRepo;
    private final RolRepo rolRepo;

    @Override
    public List<Rol> getRoles() {
        log.info("Show all roles");//Para los logs revisa Spring AOP, que es como los Hooks
        return rolRepo.findAll();
    }

    @Override
    public Rol saveRol(Rol rol) {
        log.info("Saving new role {} to the database", rol.getName());
        return rolRepo.save(rol);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        log.info("Adding role {} to user {}", role, username);
        User user = userRepo.findByUsername(username);
        Rol rol = rolRepo.findByName(role);
        user.getRoles().add(rol);
    }
}
