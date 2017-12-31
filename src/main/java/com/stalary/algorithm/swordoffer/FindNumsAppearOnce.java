/**
 * @(#)FindNumsAppearOnce.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FindNumsAppearOnce
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author lirongqian
 * @since 31/12/2017
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int[] arr = new int[]{
                2, 4, 3, 6, 3, 2, 5, 5
        };
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new FindNumsAppearOnce().FindNumsAppearOnce(arr, num1, num2);
        System.out.println("num1: " + num1[0] + "num2: " + num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int out : array) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        int i;
        for (i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                num1[0] = array[i];
                break;
            }
        }
        for (int j = i + 1; j < array.length; j++) {
            if (map.get(array[j]) == 1) {
                num2[0] = array[j];
            }
        }
    }

    /**
     * 使用list来进行判断，如果再次出现就删除
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(!list.contains(String.valueOf(array[i]))){
                list.add(String.valueOf(array[i]));
            }else{
                list.remove(String.valueOf(array[i]));
            }
        }
        if(list.size()!=0){
            num1[0] = Integer.valueOf(list.get(0));
            num2[0] = Integer.valueOf(list.get(1));
        }
    }



}