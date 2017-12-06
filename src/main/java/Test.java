import com.stalary.algorithm.algorithmbook.In;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, map.getOrDefault(1, 0) + 1);
        map.put(2, map.getOrDefault(2, 0) + 1);
        map.put(1, map.getOrDefault(1, 0) + 1);
        map.put(1, map.getOrDefault(1, 0) + 1);
        System.out.println(map);
    }


}

