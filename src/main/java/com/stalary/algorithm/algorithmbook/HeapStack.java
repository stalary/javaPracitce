package com.stalary.algorithm.algorithmbook;

/**
 * @Author:Stalary
 * @Description:基于链表实现的下压堆栈
 * @Date Created in 2017/10/3
 */
public class HeapStack<Item> {

    private Node first;//栈顶元素(最近添加的元素)
    private Integer n;

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

    public void push(Item item) {//向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {//从栈顶删除元素
        Item item = first.item;
        first = first.next;
        n--;//缩小容量
        return item;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public static void main(String[] args) {
        HeapStack<String> heapStack = new HeapStack<>();
        heapStack.setN(3);
        heapStack.push("zyw");
        heapStack.push("stalary");
        heapStack.push("hawk");
        for(int i = 0; i < heapStack.size(); i++) {
            System.out.println(heapStack.pop());
        }
    }
}
