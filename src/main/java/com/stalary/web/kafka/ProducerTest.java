/**
 * @(#)Producer.java, 2017-11-16.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.apache.log4j.Logger;

/**
 * Producer
 *
 * @author lirongqian
 * @since 2017/11/16
 */
public class ProducerTest {

    private static final Logger logger = Logger.getLogger(ProducerTest.class);
    /**
     *
     */
    private void execMsgSend() {
        Properties props = new Properties();
        props.put("metadata.broker.list", "127.0.0.1:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "0");

        ProducerConfig config = new ProducerConfig(props);

        logger.info("set config info(" + config + ") ok.");

        Producer<String, String> procuder = new Producer<>(config);

        String topic = "test";
        for (int i = 1; i <= 10; i++) {
            String value = "value_" + i;
            KeyedMessage<String, String> msg = new KeyedMessage<String, String>(topic, value);
            procuder.send(msg);
        }
        logger.info("send message over.");

        procuder.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProducerTest simpleProducer = new ProducerTest();
        simpleProducer.execMsgSend();
    }
}