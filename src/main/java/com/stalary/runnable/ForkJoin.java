/**
 * @(#)ForkJoin.java, 2018-02-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import com.stalary.tikucrawl.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * ForkJoin
 *
 * @author lirongqian
 * @since 2018/02/08
 */
public class ForkJoin extends RecursiveTask<String> {

    static final int THRESHOLD = 2;
    private int start;
    private int end;

    public ForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected String compute() {
        String sum = "";
        // 判断任务是否大于阈值
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                String s = httpJsonGet("https://api.566.com/APP/exam8/Tiku/Paper/430/16447154/143126807/GetPaper/_apple/780063694f3d6c912c10944050db7506");
                sum = sum + "ForkJoin: " + "第" + i + "次请求结果为：" + s + "\n";
            }
        } else {
            // 大于阈值时，分裂成两个自任务进行计算
            int mid = (start + end) / 2;
            ForkJoin left = new ForkJoin(start, mid);
            ForkJoin right = new ForkJoin(mid + 1, end);
            // 执行两个自任务
            left.fork();
            right.fork();
            // 获取子任务结果
            String leftResult = left.join();
            String rightResult = right.join();
            // 合并结果
            sum = leftResult + rightResult;
        }
        return sum;
    }

    static class Wait extends RecursiveTask<Integer> {

        private int start;
        private int end;

        public Wait(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            boolean canCompute = (end - start) <= THRESHOLD;
            if (canCompute) {
                for (int i = start; i <= end; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        sum += i;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int mid = (start + end) / 2;
                Wait waitLeft = new Wait(start, mid);
                Wait waitRight = new Wait(mid + 1, end);

                waitLeft.fork();
                waitRight.fork();

                int leftResult = waitLeft.join();
                int rightResult = waitRight.join();
                sum = leftResult + rightResult;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 10;
        long start2 = System.currentTimeMillis();
//        String sum = "";
        int sum = 0;
        for (int i = start; i <= end; i++) {
//            String s = httpJsonGet("https://api.566.com/APP/exam8/Tiku/Paper/430/16447154/143126807/GetPaper/_apple/780063694f3d6c912c10944050db7506");
//            sum = sum + "for: " + "第" + i + "次请求结果为：" + s + "\n";
            try {
                TimeUnit.SECONDS.sleep(1);
                sum += i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        System.out.println("time: " + (System.currentTimeMillis() - start2));
        long start1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个任务
        Wait task = new Wait(start, end);
        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
            System.out.println("time: " + (System.currentTimeMillis() - start1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String httpJsonGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("fake-user", "robot");
        // try-with-resources
        try (CloseableHttpResponse ret = HttpClient.get(httpGet)) {
            int statusCode = ret.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
//                System.out.println("request failed with code:" + statusCode);
                return null;
            }
            HttpEntity entity = ret.getEntity();
            String responseStr = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
//            System.out.println("httpJsonGet: " + url + "; " + responseStr);
            return responseStr;
        } catch (Exception e) {
//            System.out.println("httpJsonGet failure!" + e);
            return null;
        }
    }
}