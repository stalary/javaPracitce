package com.stalary.algorithm.algorithmbook;

/**
 * @Author:Stalary
 * @Description:大根堆的构建
 * @Date Created in 2017/10/3
 */
public class Heap {

    private Integer[] pq;//基于堆的完全二叉树
    private int n = 0;//存储在pq[1..n]中，pq[0]不使用

    public Heap(int max) {
        pq = new Integer[max + 1];//初始化堆的大小
    }

    public Heap() {
    }

    private boolean less(Integer i, Integer j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(Integer i, Integer j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(Integer k) {//上浮操作，若父节点小于子结点，则进行交换
        while(k > 1 && less(k/2,k)) {
            exch(k/2,k);//交换父节点和子结点
            k = k/2;//将指针移动到父节点
        }
    }

    private void sink(Integer k) {//下沉操作，当从顶端删去最大的元素并将数组的最后一个元素放到顶端后，减小堆的大小，并进行下沉操作
        while(2 * k <= n) {//判断当前结点的子结点是否存在
            int j = 2 * k;
            if(j < n && less(j, j + 1)) {
                j++;
            }//判断左右结点大小，选择较大结点的下标
            if(less(j, k)) {
                break;
            }//如果子结点小于父节点，则不进行处理
            exch(k,j);//交换较大的子结点与父节点
            k = j;//将指针移动到子结点
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Integer size() {
        return n;
    }

    public void insert(Integer v) {
        pq[++n] = v;
        swim(n);
    }

    private Integer delMax() {
        Integer max = pq[1];//堆从1开始，所以1即为堆的最大值
        exch(1, n--);//将根与最后一个结点进行交换
        pq[n + 1] = null;//将结点赋值null，便于回收
        sink(1);//通过下沉，恢复堆的特性
        return max;
    }


    public static void main(String[] args) {
        Heap heap = new Heap(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(6);
        heap.insert(8);
        heap.insert(2);
        System.out.println("初始化堆");
        for(int i = 1; i <= heap.size(); i++) {
            System.out.print(heap.pq[i] + " ");
        }
        System.out.println("删除最大元素 " + heap.delMax());
        for(int i = 1; i <= heap.size(); i++) {
            System.out.print(heap.pq[i] + " ");
        }
        System.out.println("删除最大元素 " + heap.delMax());
        for(int i = 1; i <= heap.size(); i++) {
            System.out.print(heap.pq[i] + " ");
        }
    }

}
