public class Test {
    public static void main(String[] args) {
    }

    public static int cal(int[] num) {
        int temp = 0;
        for (int i = 0; i < num.length; i++) {
            temp ^= num[i];
        }
        for (int i = 1; i < num.length; i++) {
            temp ^= i;
        }
        return temp;
    }

    public static String split(String str, int k) {
        String substring = str.substring(0, str.length() - k);
        String substring1 = str.substring(str.length() - k);
        return substring1 + substring;
    }

    static class MyQueue<E> {
        private Node<E> head = null;
        private Node<E> tail = null;

        public boolean isEmpty() {
            return head == tail;
        }

        public void put(E data) {
            Node<E> newNode = new Node<>(data);
            // 队列为空
            if (head == null && tail == null) {
                head = tail = newNode;
            } else {
                // 将新加入的值放入到队列的头
                tail.next = newNode;
                tail = newNode;
            }
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            }
            E data = head.data;
            head = head.next;
            return data;
        }

        public int size() {
            Node<E> tmp = head;
            int n = 0;
            while (tmp != null) {
                n++;
                tmp = tmp.next;
            }
            return n;
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    "head=" + head.data +
                    ", tail=" + tail.data +
                    '}';
        }
    }

    static class Node<E> {
        Node<E> next = null;
        E data;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", data=" + data+
                    '}';
        }
    }
}