package com.stalary.unusual;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/6
 */
public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(ExceptionTest.time());
        Scanner in = new Scanner(System.in);
        System.out.print("enter n:");
        int n = in.nextInt();
        f(n);
        System.out.println("----start---");
        myLogger.info("测试一下");
        System.out.println("----end----");
    }

    private static final Logger myLogger = Logger.getLogger("com.stalary");

    /**
     * 打印堆栈轨迹
     *
     **/
    private static int f(int n) {
        System.out.println("f(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for(StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if(n <= 1) {
            r = 1;
        } else {
            r = n * f(n-1);
        }
        System.out.println("return " + r);
        return r;
    }

    /**
     * 将String格式化为Date类型需要try-catch
     **/
    private static String time() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        Date d;
        try {
            d = format.parse(date);
            System.out.println(d);
            return "转化成功";
        } catch (ParseException e) {
            return "转化失败";
        }
        finally {
            return "完成转化";
        }
    }
}
