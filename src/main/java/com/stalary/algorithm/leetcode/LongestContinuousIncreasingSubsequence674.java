
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LongestContinuousIncreasingSubsequence674
 *
 * 找出最长的递增子序列
 * @author lirongqian
 * @since 2017/12/13
 */
public class LongestContinuousIncreasingSubsequence674 {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,3,5,4,7
        };
        LongestContinuousIncreasingSubsequence674 l = new LongestContinuousIncreasingSubsequence674();
        System.out.println(l.findLengthOfLCIS(nums));
    }

    /**
     * 使用一个额外的数组来进行存储子序列的长度，每次求出不递增的范围
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                result.add(i - j);
                j = i;
            }
        }
        result.add(nums.length - j);
        if (result.size() == 0) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < result.size(); i++) {
            max = Math.max(max, result.get(i));
        }
        return max;
    }

    /**
     * 不使用额外空间也可以求出最长子序列，每次递增时，将值增加，不递增时将值归1
     * @param nums
     * @return
     */
    public int findLengthOfLCIS1(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]) {
                res = Math.max(res, ++cnt);
            } else {
                cnt = 1;
            }
        }
        return res;
    }
}