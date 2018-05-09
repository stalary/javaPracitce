package com.stalary.rpc;

/**
 * EchoServiceImpl
 *
 * @author lirongqian
 * @since 2018/05/08
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I have received your message" : "no message";
    }
}