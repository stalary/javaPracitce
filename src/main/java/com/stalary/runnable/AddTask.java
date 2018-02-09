/**
 * @(#)AddTask.java, 2018-02-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * AddTask
 *
 * @author lirongqian
 * @since 2018/02/04
 */
public class AddTask implements Callable<Integer> {

    private int a, b;

    public AddTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
//        Thread.sleep(1000);
        return a + b;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        while (true) {
            System.out.println("计算开始，输入两个数字");
            Scanner in = new Scanner(System.in);
            Future<Integer> future = executor.submit(new AddTask(in.nextInt(), in.nextInt()));
            System.out.println("提交完成");
            System.out.println("去做别的事情");
            System.out.println("～～～～～～");
            System.out.println("等待计算结果");
            System.out.println(future.get());
        }
    }
}