package com.leofee.learning.sentinel.controller;

import com.leofee.learning.sentinel.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leofee
 */
@RestController
public class SentinelOpenFeignController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProviderFeign providerFeign;

    @GetMapping("/query")
    public String query() {
        return restTemplate.getForObject("http://nacos-provider/nacos_provider/query", String.class);
    }

    @GetMapping("/query2")
    public String query2() {
        return providerFeign.provider();
    }

    @GetMapping("/query3")
    public String query3() {
        return providerFeign.query();
    }
}
