package com.stalary.algorithm.wuxiuguo;

/**
 * EditDistance
 * 通过增加，删除，替换word1，使其和word2相同
 *
 * @author lirongqian
 * @since 2018/06/20
 */
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance1("ACDEF", "ABCDE"));
    }

    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        // 传入两个字符串以及下标
        return minDistanceHelper(word1, word2, 0, 0);
    }

    public int minDistance1(String word1, String word2) {
        int[][] f = new int[word1.length()][word2.length()];
        for (int i = 1; i < word1.length(); i++) {
            int min;
            f[i][0] = i;
            for (int j = 1; j < word2.length(); j++) {
                f[0][j] = j;
                min = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (word1.charAt(i) == word2.charAt(j)) {
                    min = Math.min(min, f[i - 1][j - 1]);
                } else {
                    min = Math.min(min, f[i - 1][j - 1] + 1);
                }
                f[i][j] = min;
            }
        }
        return f[word1.length() - 1][word2.length() - 1];
    }

    /**
     * 通过dp
     * 对三种状态进行判断
     * 求出最小的result
     *
     * @param word1
     * @param word2
     * @param index1
     * @param index2
     * @return
     */
    private int minDistanceHelper(String word1, String word2, int index1, int index2) {
        // 第一个字符串匹配完成，则需要进行剩余长度的操作
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }
        // 当计算过时，直接输出
        if (dp[index1][index2] > 0) {
            return dp[index1][index2];
        }
        int result;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            // 相同时继续向后查找
            result = minDistanceHelper(word1, word2, index1 + 1, index2 + 1);
        } else {
            // 替换字符
            result = 1 + minDistanceHelper(word1, word2, index1 + 1, index2 + 1);

            // 删除一个字符
            result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1 + 1, index2));

            // 添加一个字符
            result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1, index2 + 1));
        }
        dp[index1][index2] = result;
        return result;
    }
}