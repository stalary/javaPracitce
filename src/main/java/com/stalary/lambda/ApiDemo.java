package com.stalary.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * ApiDemo
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class ApiDemo {

    private Logger logger = LoggerFactory.getLogger(ApiDemo.class);

    public static void main(String[] args) {


    }

    public void debug(Supplier<String> message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message.get());
        }
    }

}