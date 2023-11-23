package com.leofee.learning.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author leofee
 */
public class BlockedHandler {

    public static String handleBlockedException(BlockException e) {
        return "系统繁忙，通过Block handler class 处理";
    }
}
