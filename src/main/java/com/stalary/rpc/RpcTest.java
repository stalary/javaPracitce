package com.stalary.rpc;

import java.net.InetSocketAddress;

/**
 * RpcTest
 *
 * @author lirongqian
 * @since 2018/05/08
 */
public class RpcTest {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RpcExporter.exporter("localhost", 8080);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        RpcImporter<EchoService> rpcImporter = new RpcImporter<>();
        EchoService echo = rpcImporter.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8080));
        System.out.println(echo.echo("I am stalary"));
    }
}