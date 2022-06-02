package org.example.repo.Auth;

import org.example.domain.Auth.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepo extends JpaRepository<Rol,Long> {
     Rol findByName(String name);
}
