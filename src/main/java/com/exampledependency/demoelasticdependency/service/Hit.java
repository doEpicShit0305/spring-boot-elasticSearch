package com.exampledependency.demoelasticdependency.service;

import com.exampledependency.demoelasticdependency.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hit {
    @JsonProperty("_source")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
