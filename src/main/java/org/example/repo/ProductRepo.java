package org.example.repo;

import org.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Falta la anotacion Repository

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
