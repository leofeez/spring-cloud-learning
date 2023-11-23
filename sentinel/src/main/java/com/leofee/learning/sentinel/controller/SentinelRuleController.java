package com.leofee.learning.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leofee.learning.sentinel.handler.BlockedHandler;
import com.leofee.learning.sentinel.service.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author leofee
 */
@RestController
public class SentinelRuleController {

    @Autowired
    private ChainService chainService;

    /**
     * 流控阈值-QPS
     */
    @GetMapping("/testQps")
    public String testQps() {
        return "sentinel rule with QPS";
    }

    /**
     * 流控阈值-并发线程数
     */
    @GetMapping("/testThread")
    public String testThread() throws InterruptedException {
        // 休眠一秒
        TimeUnit.SECONDS.sleep(1);
        return "sentinel rule with thread";
    }

    @GetMapping("/relatedA")
    public String relatedA() {
        return "sentinel rule with related A";
    }

    @GetMapping("/relatedB")
    public String relatedB() {
        return "sentinel rule with related B";
    }

    @GetMapping("/chainA")
    public String chainA() {
        return chainService.chain();
    }

    /**
     * 预热
     */
    @GetMapping("/warmUp")
    public String warmUp() {
        return "sentinel rule with warm up";
    }

    /**
     * 慢调用比例
     */
    @GetMapping("/blow/{id}")
    public String blow(@PathVariable("id") Integer id) throws InterruptedException {
        if (id > 3) {
            TimeUnit.SECONDS.sleep(3);
        }
        return "sentinel rule with blow";
    }

    /**
     * 异常数
     */
    @GetMapping("/ex/{id}")
    public String ex(@PathVariable("id") Integer id) throws InterruptedException {
        if (id > 3) {
            throw new RuntimeException("报错啦");
        }
        return "sentinel rule with ex ration";
    }

    @SentinelResource(value = "block", blockHandler = "handleBlock")
    @GetMapping("/block")
    public String blockHandler() {
        return "sentinel resource block handler";
    }

    public String handleBlock(BlockException e) {
        return "系统繁忙";
    }

    @SentinelResource(value = "blockHandlerClass", blockHandlerClass = BlockedHandler.class, blockHandler= "handleBlockedException")
    @GetMapping("/blockHandlerClass")
    public String block() {
        return "sentinel resource block handler";
    }

}
