package com.shamayko.springhomework3.repositories;

import com.shamayko.springhomework3.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Personal Happiness", 100.87f),
                new Product(2L, "Communism", 500f),
                new Product(3L, "Immortality", 59.99f),
                new Product(4L, "PS 5", 2f),
                new Product(5L, "Time machine", 200.88f)
        ));

    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().
                orElseThrow(() -> new RuntimeException("Product not found"));

    }
}
