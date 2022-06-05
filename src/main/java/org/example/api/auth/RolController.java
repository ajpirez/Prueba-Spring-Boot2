package org.example.api.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.utils.RoleToUSerForm;
import org.example.domain.auth.Rol;
import org.example.service.rol.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
@Slf4j
public class RolController {
    private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getRol() {
        return ResponseEntity.ok(rolService.getRoles());
    }


    @PostMapping
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString());
        return ResponseEntity.created(uri).body(rolService.saveRol(rol));
    }

    @PostMapping("/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUSerForm form) {
        rolService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
