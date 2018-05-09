package com.stalary.io.netty;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Nio
 *
 * @author lirongqian
 * @since 2018/05/03
 */
public class Nio {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(InetAddress.getByName("localhost"), 8080));
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        new Thread(() -> System.out.println("open")).start();
        Set selectedKeys = selector.selectedKeys();
        Iterator it = selectedKeys.iterator();
        while (it.hasNext()) {
            SelectionKey key = (SelectionKey) it.next();

        }
    }
}