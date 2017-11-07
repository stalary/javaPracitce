package com.stalary.algorithm.algorithmbook;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/10/3
 */
public class QueueDemo<Item> {

    private Node first;
    private Node last;
    private int n;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Integer size() {
        return n;
    }

    public void enqueue(Item item) {//向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }

    public Item dequeue() {//从表头删除元素
        Item item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    public static void main(String[] args) {
        QueueDemo<String> queueDemo = new QueueDemo<>();
        queueDemo.enqueue("zyw");
        queueDemo.enqueue("stalary");
        queueDemo.enqueue("hawk");
        int len = queueDemo.n;
        for(int i= 0; i < len; i++) {
            System.out.print(queueDemo.dequeue() + " ");
        }
    }
}
