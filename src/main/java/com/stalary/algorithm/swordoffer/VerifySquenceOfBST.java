/**
 * @(#)VerifySquenceOfBST.java, 2017-12-17.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * VerifySquenceOfBST
 *
 * 判断一个数组是否是一个二叉树的后序打印
 * @author lirongqian
 * @since 2017/12/17
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[] {
                7,4,6,5
        }));
    }

    /**
     * 后续遍历的最后一个元素是根结点，可以递归的通过子树来判断，左结点一定小于根结点，右结点一定大于根结点
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        return help(sequence, 0, sequence.length);
    }

    public boolean help(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[end - 1];
        int i;
        for (i = 0; i < end - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j;
        for (j = i; j < end - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            left = help(sequence, start, i);
        }
        boolean right = true;
        if (i < end - 1) {
            right = help(sequence, start + i, end - 1);
        }
        return left && right;
    }


}