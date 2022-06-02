package org.example.service.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Product;
import org.example.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;


    @Override
    public List<Product> getProducts() {//Revisa tambien lo de los DTO, solo trabajas con DAO, a veces ese es el 60% de los problemas en los CRUD, pista modelMapper
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {//Chequea el id si existe antes de eliminarlo, preferentemente aqui, no en el controller
        productRepo.deleteById(id);
    }
}
