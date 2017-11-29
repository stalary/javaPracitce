/**
 * @(#)ChangeBlank.java, 2017-11-28.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * ChangeBlank
 *
 * @author lirongqian
 * @since 2017/11/28
 */
public class ChangeBlank {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world");
        //spacenum为计算空格数
        int spacenum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spacenum++;
            }
        }
        //indexold 为替换前的 str 下标
        int indexold = str.length() - 1;
        //计算空格转换成 %20 之后的 str 长度
        int newlength = str.length() + spacenum * 2;
        //indexold 为把空格替换为 %20 后的 str 下标
        int indexnew = newlength - 1;
        //使 str 的长度扩大到转换成 %20之 后的长度,防止下标越界
        str.setLength(newlength);
        while (indexold >= 0) {
            if (str.charAt(indexold) == ' ') {
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
                spacenum--;
                // 如果最后一个空格已经被替换完了，那么剩下的字符就不需要再一个一个判断了。
                if (spacenum == 0) {
                    break;
                }
            } else {
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
            --indexold;
        }
        System.out.println(str.toString());
    }
}