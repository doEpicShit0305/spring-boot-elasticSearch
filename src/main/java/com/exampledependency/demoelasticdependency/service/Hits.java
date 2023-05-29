package com.exampledependency.demoelasticdependency.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Hits {
    @JsonProperty("hits")
    private List<Hit> hits;

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }
}
