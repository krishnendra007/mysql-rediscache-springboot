package com.rediscache.service;

import com.rediscache.config.AppConstants;
import com.rediscache.model.Product;
import com.rediscache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @CachePut(value = AppConstants.CACHE_VALUE,key = "#product.id")
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //@Cacheable(value = AppConstants.CACHE_VALUE, key = "'allProducts'")
    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    @Cacheable(value = AppConstants.CACHE_VALUE, key = "#id")
    public Product getProductById(int id){
        return repository.findById(id).orElse(new Product());
    }

    @CacheEvict(value = AppConstants.CACHE_VALUE,key = "#id")
    public String deleteProductById(int id){
        repository.deleteById(id);
        return "deleted Product with ID" +id;
    }


}
