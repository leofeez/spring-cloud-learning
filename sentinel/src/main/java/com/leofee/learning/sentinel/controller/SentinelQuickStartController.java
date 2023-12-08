package com.leofee.learning.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leofee
 */
@RestController
public class SentinelQuickStartController {

    @GetMapping("/hello")
    public String hello() {
        return "hello sentinel";
    }

    @GetMapping("/get")
    public String get() {
        // 定义需要被Sentinel保护的资源
        try (Entry entry = SphU.entry("get")) {
            // do Something
        } catch (BlockException blockException) {
            // 处理限流的异常
            return "sentinel blocked";
        }
        return "get success";
    }

    @GetMapping("/ifElse")
    public String ifElse() {
        if (SphO.entry("ifElse")) {
            try {
                // do Something
            } finally {
                SphO.exit();
            }
            return "success";
        } else {
            return "sentinel blocked";
        }
    }

    public void context() {
        // 创建Context，入口名为entrance01，应用名app01
        ContextUtil.enter("entrance01", "app01");


        ContextUtil.exit();
    }
}
