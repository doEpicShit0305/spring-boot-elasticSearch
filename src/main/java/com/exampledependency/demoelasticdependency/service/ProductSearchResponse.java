package com.exampledependency.demoelasticdependency.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.elasticsearch.client.eql.EqlSearchResponse;

public class ProductSearchResponse {
    @JsonProperty("hits")
    private EqlSearchResponse.Hits hits;

    public EqlSearchResponse.Hits getHits() {
        return hits;
    }

    public void setHits(EqlSearchResponse.Hits hits) {
        this.hits = hits;
    }
}
