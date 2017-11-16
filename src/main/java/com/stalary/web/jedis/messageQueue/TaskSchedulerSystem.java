
/**
 *
 */
package com.stalary.web.jedis.messageQueue;

/**
 * <p>Title: TaskShedulerSystem</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author 夏 杰
 * @date 2015年12月11日 下午4:19:09
 * @vesion 1.0
 */
public class TaskSchedulerSystem {
    public static void main(String[] args) throws Exception {

        // 启动一个生产者线程，模拟任务的产生
        new Thread(new TaskProducer()).start();

        Thread.sleep(15000);

        //启动一个线程者线程，模拟任务的处理
        new Thread(new TaskConsumer()).start();

        //主线程休眠
        Thread.sleep(Long.MAX_VALUE);
    }
}

