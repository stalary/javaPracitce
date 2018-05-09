
package com.stalary.algorithm.leetcode;

/**
 * FloodFill733
 *
 * sr，sc为原点，newColor为修改后的像素，将与原点相连且数值相等的像素全部设为新像素，输出数组
 * @author lirongqian
 * @since 2017/11/27
 */
public class FloodFill733 {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        int[][] out = floodFill(image, 1, 1, 2);
        for (int[] o : out) {
            for (int oo : o) {
                System.out.print(oo + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
    }

}