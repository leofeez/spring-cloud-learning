package com.leofee.learning.sentinel.context;

import com.alibaba.csp.sentinel.context.Context;
import com.alibaba.csp.sentinel.context.ContextUtil;

/**
 * @author leofee
 */
public class ContextDemo {

    public static void main(String[] args) {
        Context context = ContextUtil.enter("entrance1", "appA");

    }
}
