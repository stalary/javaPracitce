package com.stalary.rpc;

/**
 * EchoService
 * Rpc服务接口提供
 * @author lirongqian
 * @since 2018/05/08
 */
public interface EchoService {

    String echo(String ping);
}