package com.stalary.order;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/22
 */
public class StaticDemo {

        static
        {
            System.out.println("1");
        }
        {
            System.out.println("2");
        }
        public StaticDemo()
        {
            System.err.println("3");
        }
        public static void main(String[] args)
        {
            new StaticDemo();
        }
}
