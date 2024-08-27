package com.rediscache.controller;

import com.rediscache.model.Product;
import com.rediscache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return  service.saveProduct(product);
    }

    @GetMapping
    public List<Product> findAllProduct(){
        return  service.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById (@PathVariable int id){
        return service.deleteProductById(id);
    }
}
