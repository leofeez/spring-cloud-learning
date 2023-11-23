package com.leofee.learning.sentinel.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FeignClient代表
 * 要调用的服务端名称，同时使用与服务提供者
 * 方法签名一致的抽象方法来表示远程调用的
 */
@FeignClient(value = "nacos-provider", fallback = ProviderFeignImpl.class)
@Service
public interface ProviderFeign {

    @GetMapping("/nacos_provider/provider")
    String provider();

    @GetMapping("/nacos_provider/query")
    String query();
}
