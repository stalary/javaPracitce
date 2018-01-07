/**
 * @(#)GetMedian.java, 2018-01-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.PriorityQueue;

/**
 * GetMedian
 *
 * 从输入流中获取中位数
 * @author lirongqian
 * @since 2018/01/07
 */
public class GetMedian {

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        if (count % 2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}