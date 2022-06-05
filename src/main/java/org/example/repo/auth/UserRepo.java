package org.example.repo.auth;

import org.example.domain.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
