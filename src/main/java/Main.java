/**
 * @(#)Main1.java, 2018-09-09.
 * <p>
 * Copyright 2018 Stalary.
 */

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/09
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("java.util.Random");
        System.out.println(clazz);
    }

    public static class Child extends Parent {
        static {
            System.out.println("child static");
        }
    }

    public static class Parent {
        public static final String name = "stalary";
        static {
            System.out.println("parent static");
        }
    }

}