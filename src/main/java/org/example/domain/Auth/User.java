package org.example.domain.Auth;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)//Comprobaste en BD que se crea bien? con los id y todo?
    private Collection<Rol> roles = new ArrayList<>();

}
