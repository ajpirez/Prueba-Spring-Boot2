package org.example;

import org.example.domain.Rol;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRol(new Rol(null, "USER"));
            userService.saveRol(new Rol(null, "MANAGER"));
            userService.saveRol(new Rol(null, "ADMIN"));
            userService.saveRol(new Rol(null, "SUPER_ADMIN"));

            userService.saveUser(new User(null,"Alejandro Pirez","ajpirez", "123456", new ArrayList<>()));
            userService.saveUser(new User(null,"Prueba","prueba", "prueba123456", new ArrayList<>()));

            userService.addRoleToUser("ajpirez","SUPER_ADMIN");
            userService.addRoleToUser("ajpirez","ADMIN");
            userService.addRoleToUser("ajpirez","USER");
            userService.addRoleToUser("prueba","USER");
            userService.addRoleToUser("prueba","MANAGER");
        };
    }
}