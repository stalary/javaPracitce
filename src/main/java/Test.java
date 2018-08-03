import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newWorkStealingPool();
        Map<Integer, String> map = Maps.newHashMap();
        LinkedList<Integer> queue = Lists.newLinkedList();
        for (int i = 0; i < 1000; i++) {
            queue.add(i);
        }
        executorService.submit(() -> {
            while (queue.peek() != null) {
                Integer remove = queue.remove(0);
                map.put(remove, "test1:" + remove);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(() -> {
            while (queue.peek() != null) {
                Integer remove = queue.remove(0);
                map.put(remove, "test2:" + remove);
            }
        });
        while (map.size() != 1000) {
            Thread.yield();
        }
    }
}