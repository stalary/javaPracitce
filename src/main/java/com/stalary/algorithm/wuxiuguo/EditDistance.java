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
}