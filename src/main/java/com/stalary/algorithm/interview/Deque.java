package com.stalary.algorithm.interview;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双向队列，实现头进，头出，尾进，尾出
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public Deque() {
        n = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("can't add null element!");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        // it is an empty queue..
        if (oldFirst == null) {
            last = first;
            first.next = null;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        n++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("can't add null element!");
        }
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (oldlast == null) {
            first = last;
            last.prev = null;
        } else {
            last.prev = oldlast;
            oldlast.next = last;
        }
        n++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "Can't remove from empty deque");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (n == 0) {
            last = null;
        } else {
            first.prev = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "Stack underflow");
        }
        Item item = last.item;
        last = last.prev;
        n--;
        if (n == 0) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove is not supported!");
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> dq = new Deque<String>();
        dq.addFirst("A");
        dq.addFirst("B");
        dq.addFirst("C");
        dq.addLast("Q");
        dq.addLast("E");
        dq.addLast("D");
        for (String s : dq) {
            System.out.println(s);
        }
        System.out.println("Remove first" + dq.removeFirst());
        System.out.println("Remove last" + dq.removeLast());
        for (String s : dq) {
            System.out.println(s);
        }
    }
}