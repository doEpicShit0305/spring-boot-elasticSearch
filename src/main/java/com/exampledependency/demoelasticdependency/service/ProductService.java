package com.exampledependency.demoelasticdependency.service;

import com.exampledependency.demoelasticdependency.model.Product;
import com.exampledependency.demoelasticdependency.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final WebClient webClient;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9200").build();
    }

    @Autowired
    private  ProductRepository productRepository;
//    public Iterable<Product> getProducts(String field, String filter){
//        String indexName = "documents";
//        String url = "/" + indexName + "/_search";
//        String requestBody = "{\"query\": {\"term\": {\"" + field + "\": \"" + filter + "\"}}}";
////        String requestBody = "{ \"query\": { \"bool\": { \"must\": [ { \"term\": { \"" + field + "\": \"" + filter + "\" } }, { \"range\": { \"" + rangeField + "\": { \"gte\": " + minValue + " } } } ] } } }";
//        return webClient.post()
//                .uri(url)
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(String.class)
//                .flatMap(this::processSearchResponse)
//                .block();
//
////        return productRepository.findAll();
//    }
public Iterable<Product> getProducts(String field, String filter) {
    String indexName = "documents";
    String url = "/" + indexName + "/_search";
    String requestBody = "{\"query\": {\"term\": {\"" + field + "\": \"" + filter + "\"}}}";

    Mono<ProductSearchResponse> responseMono = webClient.post()
            .uri(url)
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(ProductSearchResponse.class);

    return responseMono.flatMap(this::processSearchResponse).block();
}
    private Mono<Iterable<Product>> processSearchResponse(ProductSearchResponse response) {

        return Mono.empty();

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
