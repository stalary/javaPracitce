/**
 * @(#)Nio.java, 2018-03-20.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Nio
 *
 * @author lirongqian
 * @since 2018/03/20
 */
public class Nio {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/mac/test.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 写入到buffer
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            // 从buffer中读取，从写模式切换到读模式
            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            // 清空缓冲区
            buf.clear();
            // 继续读取
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}