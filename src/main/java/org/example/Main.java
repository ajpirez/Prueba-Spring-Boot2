package org.example;

import org.example.domain.Rol;
import org.example.domain.User;
import org.example.service.UserService;
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
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRol(new Rol(null, "ROLE_USER"));
            userService.saveRol(new Rol(null, "ROLE_MANAGER"));
            userService.saveRol(new Rol(null, "ROLE_ADMIN"));
            userService.saveRol(new Rol(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Alejandro Pirez","ajpirez", "123456", new ArrayList<>()));
            userService.saveUser(new User(null,"Prueba","prueba", "prueba123456", new ArrayList<>()));

            userService.addRoleToUser("ajpirez","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("ajpirez","ROLE_ADMIN");
            userService.addRoleToUser("ajpirez","ROLE_USER");
            userService.addRoleToUser("prueba","ROLE_USER");
            userService.addRoleToUser("prueba","ROLE_MANAGER");
        };
    }
}