package com.example.demo1.interfaces;

import com.example.demo1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.id = ?1" )
    List<Product> filterProductsById(Long id);

    @Query(value = "SELECT p FROM Product p WHERE p.type = ?1" )
    List<Product> filterProductsByType(String type);
}
