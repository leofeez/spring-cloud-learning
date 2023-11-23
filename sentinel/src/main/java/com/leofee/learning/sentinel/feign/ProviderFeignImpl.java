package com.leofee.learning.sentinel.feign;

import org.springframework.stereotype.Service;

/**
 * @author leofee
 */
@Service
public class ProviderFeignImpl implements ProviderFeign {
    @Override
    public String provider() {
        return "系统繁忙1";
    }

    @Override
    public String query() {
        return "系统繁忙2";
    }
}
