/**
 * @(#)InetAddress.java, 2017-11-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.socket;

import lombok.Cleanup;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

/**
 * InetAddress
 *
 * @author lirongqian
 * @since 2017/11/7
 */
public class Server {

    public static void main(String[] args) throws Exception {
            // 1、创建一个服务器Socket，即ServerSocket，指定绑定的端口，并监听此端口
            @Cleanup ServerSocket serverSocket = new ServerSocket(8888);
            // 2、调用()方法开始监听，等待客户端的连接
            System.out.println("***服务器即将启动，等待客户端的连接***");
            @Cleanup Socket socket = serverSocket.accept();// 就会处于阻塞的状态，等待监听
            // 3、获取输入流，病读取客户端信息
            InputStream is = socket.getInputStream();// 字节输入流
            // 将字节流转换为字符流
            @Cleanup InputStreamReader isr = new InputStreamReader(is);
            // 为输入流添加缓冲
            @Cleanup BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，读取客户端发过来的信息：" + info);
            }
            socket.shutdownInput();//关闭输入流

    }

}