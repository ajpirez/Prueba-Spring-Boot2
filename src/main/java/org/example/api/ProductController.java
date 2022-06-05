package org.example.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Product;
import org.example.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")//No utilices mayuscula en ningun endpoint, al igual que para ningun directorio, por ejemplo Auth
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping//No hace falta el ("") puedes dejarlo @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")//No hace falta el path puedes dejarlo @GetMapping("id")
    public Product getProduct(@PathVariable() Long id) {
        return productService.getProduct(id).get();
    }

    @PostMapping//No hace falta el () puedes dejarlo @PostMapping
    public ResponseEntity<Product> saveOrUpdateProduct(@RequestBody Product product) {//Separa el guardar y el actualizar, al actualizar no le puedes dar response code 201, es 200
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString()); //Encuentra como hacer el created, es una boberia pero es algo que vas a hacer todo el tiempo
        return ResponseEntity.created(uri).body(productService.saveOrUpdateProduct(product));
    }

    @DeleteMapping("/{id}")//Lo mismo que el GetMapping de arriba
    public ResponseEntity<String> deleteProduct(@PathVariable() Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");//No devuelvas String en el Body del ResponseEntity, devuelve un Objeto Respuesta
    }
}
