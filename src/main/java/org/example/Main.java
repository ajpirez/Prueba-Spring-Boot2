package org.example;

import org.example.domain.Rol;
import org.example.domain.User;
import org.example.service.Rol.RolService;
import org.example.service.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RolService rolService) {
        return args -> {
            rolService.saveRol(new Rol(null, "ROLE_ADMIN"));
            rolService.saveRol(new Rol(null, "ROLE_OPERATOR"));

            userService.saveUser(new User(null, "Alejandro Pirez", "ajpirez", "123456", new ArrayList<>()));
            userService.saveUser(new User(null, "Operador", "operator", "operator123456", new ArrayList<>()));

            rolService.addRoleToUser("ajpirez", "ROLE_ADMIN");
            rolService.addRoleToUser("operator", "ROLE_OPERATOR");
        };
    }
}