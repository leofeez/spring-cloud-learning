package com.learning.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leofee
 */
@RestController
public class HelloGatewayController {

    @GetMapping("/hello")
    public String hello() {
        return "hello gateway";
    }
}
