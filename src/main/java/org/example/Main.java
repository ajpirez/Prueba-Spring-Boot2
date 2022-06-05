package org.example;

import org.example.domain.Product;
import org.example.domain.Section;
import org.example.domain.auth.Rol;
import org.example.domain.auth.User;
import org.example.domain.Store;
import org.example.domain.utils.Enum.ContainerType;
import org.example.domain.utils.Enum.ProductType;
import org.example.service.product.ProductService;
import org.example.service.rol.RolService;
import org.example.service.section.SectionService;
import org.example.service.store.StoreService;
import org.example.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

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
            Store st1 = new Store(null, "Almacen2", null);
            st1.setName("Almacen2");
            st1.setSections(new ArrayList<>());

            Section s1 = new Section();
            s1.setSize(10.2);
            s1.setProductType(ProductType.ELECTRODOMESTICOS);
            s1.setProducts(new ArrayList<>());
            s1.setStore(st1);
//            sectionService.saveOrUpdateSection(s1);

            Product p1 = new Product(null, 10.2, "blue", 10.2, true, ContainerType.CARTON, 12, s1);

            productService.saveOrUpdateProduct(p1);

//            System.out.println(((Object)containerType[0]).getClass().getSimpleName());
            //((Object)myInteger).getClass().getSimpleName())
//            Section s1 = new Section();
//            s1.setId(null);
//            s1.setSize(10.2);
//            s1.setProduct(p1);
//            s1.setStore(st1);
//            sectionService.saveOrUpdateSection(s1);
//            Section section = sectionService.saveOrUpdateSection(new Section(null, 10.2, p1, st1));
//            sectionService.saveOrUpdateSection(new Section(null, 10.4, product1, store1));

        };
    }
}