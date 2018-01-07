import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    public static void main(String[] args) {

        int[] num = new int[]{
                10, 23, 15, 44, 2, 1, 5, 9, 4
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqr = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int out : num) {
            pq.offer(out);
            pqr.offer(out);
        }
        System.out.println(new Test().cal(10865));
    }

    public int cal(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        sum += i;
        return sum;
    }

}



