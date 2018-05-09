
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * IntersectionOfTwoArraysII
 * <p>
 * 输入两个数组，求交集，注意从HashMap中进行取值时需要先判断是否存在，再进行值的比较
 *
 * @author lirongqian
 * @since 2017/12/10
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = new int[]{
                2, 6, 2, 9, 1
        };
        int[] nums2 = new int[]{
                7, 1
        };
        int[] nums3 = intersect(nums1, nums2);
        for (int out : nums3) {
            System.out.print(out + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int out : nums1) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        for (int out : nums2) {
            if (map.get(out) != null && map.get(out) > 0) {
                map.put(out, map.get(out) - 1);
                list.add(out);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}