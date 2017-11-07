package com.stalary.algorithm.algorithmbook;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/19
 */
public class List {

    public static void main(String[] args) {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();

        first.item = "stalary";
        second.item = "clairezyw";
        third.item = "hawk";

        first.next = second;
        second.next = third;

        first.next = first;
        System.out.println(first.next);
    }

}

class Node {
    String item;
    Node next;

    @Override
    public String toString() {
        return "item='" + item + "'";
    }
}

