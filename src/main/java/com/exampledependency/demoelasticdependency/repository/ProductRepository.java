package com.exampledependency.demoelasticdependency.repository;

import com.exampledependency.demoelasticdependency.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {

}
