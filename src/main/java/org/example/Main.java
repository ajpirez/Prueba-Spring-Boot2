package org.example;

import org.example.domain.Auth.Rol;
import org.example.domain.Auth.User;
import org.example.domain.Product;
import org.example.domain.Section;
import org.example.domain.Store;
import org.example.domain.Utils.Enum.ContainerType;
import org.example.service.Product.ProductService;
import org.example.service.Rol.RolService;
import org.example.service.Section.SectionService;
import org.example.service.Store.StoreService;
import org.example.service.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

//Una talla buena aqui que da puntos, es aprender a trabajar con la Cache, es bastante sencillo, Baeldung
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
    CommandLineRunner run(UserService userService, RolService rolService, StoreService storeService, ProductService productService, SectionService sectionService) {
        return args -> {
            //Roles
            rolService.saveRol(new Rol(null, "ROLE_ADMIN"));
            rolService.saveRol(new Rol(null, "ROLE_OPERATOR"));
            //Users
            userService.saveUser(new User(null, "Alejandro Pirez", "ajpirez", "123456", new ArrayList<>()));
            userService.saveUser(new User(null, "Operador", "operator", "operator123456", new ArrayList<>()));
            //Permition
            rolService.addRoleToUser("ajpirez", "ROLE_ADMIN");
            rolService.addRoleToUser("operator", "ROLE_OPERATOR");
            //Store
//            storeService.saveOrUpdateStore(new Store(null, "Almacen1"));
            Store store1 = storeService.saveOrUpdateStore(new Store(null, "Almacen2", new ArrayList<>()));
            //Product
            ContainerType type = ContainerType.CARTON;
            System.out.println(type);

//                Product product1 = productService.saveOrUpdateProduct(new Product(null,type,10.2,"blue",10.2,true,23,12,new Section()));

//            System.out.println(((Object)containerType[0]).getClass().getSimpleName());
            //((Object)myInteger).getClass().getSimpleName())
//            Section section = new Section(null, 10.2, 5, 5);
//            sectionService.saveOrUpdateSection(new Section(null, 10.4, product1, store1));

        };
    }
}