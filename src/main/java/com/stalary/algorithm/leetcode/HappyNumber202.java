
package com.stalary.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * HappyNumber202
 *
 * @author lirongqian
 * @since 2017/12/16
 */
public class HappyNumber202 {

    public static void main(String[] args) {
        HappyNumber202 h = new HappyNumber202();
        System.out.println(h.isHappy(19));

    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }

}