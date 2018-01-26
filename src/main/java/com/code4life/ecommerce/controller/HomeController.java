package com.code4life.ecommerce.controller;

import com.code4life.ecommerce.model.Product;
import com.code4life.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "home";
    }

    @PostMapping
    public String homePost(@ModelAttribute("product") Product product) {

        if (product != null) {
            Product returned = productService.saveProduct(product);
            LOG.debug("Created product is {} ", returned);
        }

        return "redirect:/products";
    }

    @GetMapping(value = "/products")
    public String getProducts(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "home";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }





}
