package com.stalary.rpc;

/**
 * EchoServiceImpl1
 *
 * @author lirongqian
 * @since 2018/05/09
 */
public class EchoServiceImpl1 implements EchoService {
    @Override
    public String echo(String ping) {
        return ping == null ? "null" : ping + " is not null";
    }
}