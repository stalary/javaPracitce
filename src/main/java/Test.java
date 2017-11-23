import com.stalary.algorithm.algorithmbook.In;

import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {


    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set);
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

