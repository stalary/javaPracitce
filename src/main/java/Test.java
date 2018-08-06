import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        long start1 = System.currentTimeMillis();
        list.forEach(Test::work);
        System.out.println("cost time." + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        list.stream().parallel().forEach(Test::work);
        System.out.println("parallel cost time." + (System.currentTimeMillis() - start2));

    }

    public static void work(int i)  {
        try {
            System.out.println("work: " + i + " do");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}