package com.stalary.runnable;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/9
 */
public class RunnableTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}

class Calculator implements Runnable {
    private int number;
    public Calculator(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(),
                    number, i, i * number);
        }
    }
}