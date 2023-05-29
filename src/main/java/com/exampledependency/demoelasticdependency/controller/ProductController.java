package com.exampledependency.demoelasticdependency.controller;

import com.exampledependency.demoelasticdependency.model.Product;
import com.exampledependency.demoelasticdependency.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/findAll")
    Iterable<Product> findAll(){
        return productService.getProducts();

//    @GetMapping("/findAll")
//    Iterable<Product> findAll(){
//        return productService.getProducts();
//    }

    @PostMapping("/findAll")
    public Iterable<Product> findAll(@RequestParam String field, @RequestParam String filter) {
        return productService.getProducts(field, filter);
    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product){
       return productService.insertProduct(product);
    }

}

