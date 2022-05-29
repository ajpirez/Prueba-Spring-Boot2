package org.example.repo;

import org.example.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository<Rol,Long> {
     Rol findByName(String name);
}
