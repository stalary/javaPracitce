/**
 * @(#)SpliteratorImpl.java, 2018-01-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * SpliteratorImpl
 * 对Spliterator并行迭代器的解释
 * @author lirongqian
 * @since 2018/01/08
 */
public class SpliteratorImpl {

    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        // 初始化list
        init();
        // 获取一个并行迭代器，相比Iterator的顺序遍历，实现了并行遍历
        Spliterator<Integer> s1 = list.spliterator();
        /**
         * boolean tryAdvance(Consumer<? super T> action);
         * 顺序处理每一个元素，类似Iterator
         * 如果还有剩余元素，则返回true，否则返回false
         * 传入lambda的action
         */
        // 1
        System.out.print("s1.tryAdvance: ");
        s1.tryAdvance(System.out::println);
        // 2
        System.out.print("s1.tryAdvance: ");
        s1.tryAdvance(System.out::println);
        /**
         * Spliterator<T> trySplit();
         * 把当前元素进行划分(每次划分，都会拿到原始元素一半的元素)，返回新的Spliterator
         * 如果元素个数无法再划分，则返回null
         */
        Spliterator<Integer> sp1 = s1.trySplit();
        // 34
        System.out.print("s1.trySplit: ");
        sp1.forEachRemaining(System.out::print);
        System.out.println();
        Spliterator<Integer> sp2 = s1.trySplit();
        // 6
        System.out.print("s1.trySplit: ");
        sp2.forEachRemaining(System.out::print);
        System.out.println();
        Spliterator<Integer> sp3 = s1.trySplit();
        // null，因为原始元素的大小为1，无法再继续划分。
        System.out.print("s1.trySplit: ");
        System.out.print(sp3);
        System.out.println();
        /**
         * long estimateSize();
         * 估算还剩余多少个元素需要遍历
         */
        // 1，因为只剩下一个之前无法划分的元素
        System.out.print("s1.estimateSize: ");
        System.out.println(s1.estimateSize());
        // 重新初始化创建迭代器
        Spliterator<Integer> s2 = list.spliterator();
        // 6
        System.out.print("s2.estimateSize: ");
        System.out.println(s2.estimateSize());
        /**
         * default long getExactSizeIfKnown();
         * 如果存在size的特征，则返回大小
         */
        // 6
        System.out.print("s2.estimateSize: ");
        System.out.println(s2.estimateSize());
        /**
         * int characteristics();
         * 返回当前Spliterator的特征值
         */
        // 16464
        System.out.print("s2.characteristics: ");
        System.out.println(s2.characteristics());
        /**
         * default boolean hasCharacteristics(int characteristics);
         * 判断是否存在当前特征值
         */
        // true
        System.out.print("s2.hasCharacteristics: ");
        System.out.println(s2.hasCharacteristics(0x00000040));
    }

    public static void init() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(1);
    }
}