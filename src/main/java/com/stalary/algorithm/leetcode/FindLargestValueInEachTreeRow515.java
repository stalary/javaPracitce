/**
 * @(#)FindLargestValueInEachTreeRow515.java, 2017-12-27.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * FindLargestValueInEachTreeRow515
 *
 * 找出每一层的最大值
 * @author lirongqian
 * @since 27/12/2017
 */
public class FindLargestValueInEachTreeRow515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}