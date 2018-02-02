/**
 * @(#)Client.java, 2017-11-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.socket;

import lombok.Cleanup;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client
 *
 * @author lirongqian
 * @since 2017/11/7
 */
public class Client {

    public static void main(String[] args) throws Exception {
            // 1、创建客户端Socket，指定服务器地址和端口
            @Cleanup Socket socket = new Socket("localhost", 8888);
            // 2、获取输出流，向服务器端发送信息
            @Cleanup OutputStream os = socket.getOutputStream();// 获取字节输出流
            // 将输出流包装为打印流
            @Cleanup PrintWriter pw = new PrintWriter(os);
            pw.write("第" + 1 + "条消息");
            pw.flush();
            socket.shutdownInput();//关闭输出流
    }
}