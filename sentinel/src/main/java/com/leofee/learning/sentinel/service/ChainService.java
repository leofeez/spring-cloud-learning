package com.leofee.learning.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Component;

/**
 * @author leofee
 */
@Component
public class ChainService {

    @SentinelResource(value = "chain", blockHandler = "handleBlock")
    public String chain() {
        return "sentinel flow limit with chain";
    }

    public static String handleBlock() {
        return "系统繁忙";
    }
}
