package com.pragma.bootcamp.domain.spi;

import com.pragma.bootcamp.domain.model.Product;

import java.util.List;

public interface IProductPersistencePort {
    void saveProduct(Product product);
    Product getProduct(String name);
    List<Product> getAllProducts(Integer page, Integer size);
    List<Product> getAllProductsBySupplier(String supplier, Integer page, Integer size);
    List<Product> getAllSoldOutProducts(Integer page, Integer size);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
}
