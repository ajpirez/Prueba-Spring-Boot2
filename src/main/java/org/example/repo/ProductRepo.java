package org.example.repo;

import org.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//Falta la anotacion Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
