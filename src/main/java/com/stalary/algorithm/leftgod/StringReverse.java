package com.stalary.algorithm.leftgod;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/22
 */
public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverseByBuffer(new StringBuffer("pig loves dog")));
        System.out.println(reverseByString("pig loves dog"));
        String temp = reserve("pig loves dog");
        /**
         * 使用逆置函数进行转化
         * */
        String finalStr = "";
        String[] strings = temp.split(" ");
        for(int i = 0; i < strings.length; i++) {
            strings[i] = reserve(strings[i]);
            if(i != 0) {
                finalStr += " " + strings[i];
            } else {
                finalStr += strings[i];
            }
        }
        System.out.println(finalStr);

        System.out.println(move("ABCDE",2));

        System.out.println(sort("ba","ba"));
    }

    /**
     * 将字符串逆序输出，通过StringBuffer实现
     * pig loves dog ->dog loves pig
     * */
    private static String reverseByBuffer(StringBuffer str) {
        StringBuffer temp = str.reverse();
        String[] strings = temp.toString().split(" ");
        String finalStr = "";
        StringBuffer[] stringBuffers = new StringBuffer[strings.length];
        for(int i = 0; i < strings.length; i++) {
            stringBuffers[i] = new StringBuffer(strings[i]);
            stringBuffers[i] = stringBuffers[i].reverse();
        }
        for(int i = 0; i < stringBuffers.length; i++) {
            if(i != 0) {
                finalStr += " " + stringBuffers[i].toString();
            } else {
                finalStr += stringBuffers[i].toString();
            }
        }
        return finalStr;
    }


    /**
     * 先进行切割字符串，再进行逆置
     * */
    private static String reverseByString(String str) {
        String[] strings = str.split(" ");
        String finalStr = "";
        for(int i = strings.length - 1; i >= 0; i--) {
            if(i != strings.length - 1) {
                finalStr += " " + strings[i];
            } else {
                finalStr += strings[i];
            }
        }
        return finalStr;
    }

    /**
     * 逆置函数
     * */
    private static String reserve(String str) {
        String finalStr = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            finalStr += str.charAt(i);
        }
        return finalStr;
    }


    /**
     * 给定字符串str和i，将str[0,i]移到右侧，str[i+1,N-1]移到左侧
     * 重点为substring的start和end，截取的地方不包括end
     * */
    private static String move(String str, Integer i) {
        return reserve(reserve(str.substring(0,i+1)) + reserve(str.substring(i+1,str.length())));
    }

    /**
     * 拼接，两个字符串，使按字典排序最小
     * ba + b -> bab
     * */
    private static String sort(String str1, String str2) {
        if((str1+str2).compareTo(str2+str1) < 0) {
            return str1 + str2;
        } else {
            return str2 + str1;
        }
    }
}
