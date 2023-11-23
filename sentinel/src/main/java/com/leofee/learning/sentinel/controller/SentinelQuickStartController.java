package com.leofee.learning.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leofee
 */
@RestController
public class SentinelQuickStartController {

    @GetMapping("hello")
    public String hello() {
        return "hello sentinel";
    }
}
