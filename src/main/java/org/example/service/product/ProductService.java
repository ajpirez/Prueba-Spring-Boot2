package org.example.service.product;

import org.example.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();

    Optional<Product> getProduct(Long id);

    Product saveOrUpdateProduct(Product product);


    void deleteProduct(Long id);
}
