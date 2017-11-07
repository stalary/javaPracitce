package com.stalary.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/6
 */
public class Test {

    public static void main(String[] args) {
        BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
        BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
        bp.processBusiness();
    }
}
