package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/22
 */
public class StringRotate {

    public static void main(String[] args) {

    }

    /**
     * 传入两个参数，str1和str2，判断是否互为旋转词，旋转词为，将str1中任意部分放到后面形成的字符串
     * 1234->2341->3412，使用kmp算法
     * **/
    //todo:待完成
    public static boolean judge(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        String temp = str1 + str1;
        return true;
    }
}
