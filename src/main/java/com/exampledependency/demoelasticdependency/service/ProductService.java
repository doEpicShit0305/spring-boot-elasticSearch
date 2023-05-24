package com.exampledependency.demoelasticdependency.service;

import com.exampledependency.demoelasticdependency.model.Product;
import com.exampledependency.demoelasticdependency.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;
    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product insertProduct(Product product){
        return productRepository .save(product);
    }

    public Product updateProduct(Product product, int id){
        Product product1 = productRepository.findById(id).get();
        product1.setPrice(product.getPrice());
        return product1;
    }
}
