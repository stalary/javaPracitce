package com.stalary.order;

/**
 * @Author:Stalary
 * @Description:执行顺序的demo
 * @Date Created in 2017/9/5
 */
public class ExecuteOrder {

    public static void main(String[] args) {
        new Child();
        System.out.print(Parent.name);
        System.out.print(Child.name);
        System.out.println();
        new Child();
    }
}

class Parent {

    static String name = "parent ";

    public Parent() {
        System.out.print("1 ");
    }

    {
        System.out.print("2 ");
    }

    static {
        System.out.print("3 ");
        name = "parent1 ";
    }

}

class Child extends Parent{

    {
        System.out.print("5 ");
    }

    public Child() {
        System.out.print("4 ");
    }

    {
        System.out.print("7 ");
    }

    static {
        System.out.print("6 ");
        name = "child1 ";
    }

    static String name = "child ";
}
