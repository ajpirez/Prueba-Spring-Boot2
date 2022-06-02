package org.example.repo.Auth;

import org.example.domain.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
