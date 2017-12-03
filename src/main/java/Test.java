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


    public static void main(String[] args) throws Exception {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(1, 5);
//        System.out.println(list.poll());
//        System.out.println(list);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2, 1);
        System.out.println(map.putIfAbsent(2,3));
        System.out.println(map.get(2));

    }
}

