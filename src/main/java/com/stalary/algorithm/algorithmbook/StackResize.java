package com.stalary.algorithm.algorithmbook;

import java.util.Iterator;

/**
 * @Author:Stalary
 * @Description:能够动态调整数组大小的实现
 * @Date Created in 2017/10/3
 */
public class StackResize<T> implements Iterable<T>{

    private T[] a = (T[]) new Object[1];
    private Integer n = 0;

    private boolean isEmpty() {
        return n == 0;
    }

    private Integer size() {
        return n;
    }

    private void resize(int max) {//改变容量
        T[] temp = (T[]) new Object[max];
        for(int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    private void push(T t) {
        if(n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = t;
    }

    private T pop() {
        T t = a[--n];
        a[n] = null;
        if(n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return t;
    }

    public static void main(String[] args) {
        StackResize<String> stackResize = new StackResize<>();
        stackResize.push("stalary");
        stackResize.push("clairezyw");
        stackResize.push("hawk");
        System.out.println("初始化栈");
        for(String s : stackResize) {
            System.out.print(s + " ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackResizeIterator();
    }

    private class StackResizeIterator implements Iterator<T> {

        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }
}
