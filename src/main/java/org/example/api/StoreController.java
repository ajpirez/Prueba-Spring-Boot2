package org.example.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Section;
import org.example.domain.Store;
import org.example.domain.dto.StoreDTO;
import org.example.service.store.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store")//No mayusculas, aqui las mismas anotaciones que para Product
@RequiredArgsConstructor
@Slf4j
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoreDTO>> getStores() {
        return ResponseEntity.ok(storeService.getStores());
    }

    @GetMapping("/{id}")
    public Store getStore(@PathVariable() Long id) {//No devuelvas Optional nunca, devuelve el objeto de adentro y maneja la excepcion en un Exception Handler
        return storeService.getStore(id).get();
    }

    @PostMapping
    public ResponseEntity<Store> saveOrUpdateStore(@RequestBody Store store) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString());
        return ResponseEntity.created(uri).body(storeService.saveOrUpdateStore(store));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteSection(@PathVariable() Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.ok("Section deleted");
    }
}
