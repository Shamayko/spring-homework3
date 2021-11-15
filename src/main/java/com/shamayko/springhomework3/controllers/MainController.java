package com.shamayko.springhomework3.controllers;

import com.shamayko.springhomework3.data.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.shamayko.springhomework3.repositories.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    private ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showProductInfoPage(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";

    }


}
