import java.io.IOException;
import java.util.*;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {


    public static void main(String[] args) throws IOException {
        String str = "123 456 789";
        StringBuilder sb = new StringBuilder(str);
        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            temp += str.charAt(i);
        }
        System.out.println("手写：" + temp);
        System.out.println("逆置函数：" + sb.reverse().toString());

    }

    private static void insert(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}

