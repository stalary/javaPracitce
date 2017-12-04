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

        Map<String, Object> map = new HashMap<>();
        List<String> pic = new ArrayList<>();
        pic.add("http://1221312");
        pic.add("http://321321321");
        map.put("userScore", 5);
        map.put("images", pic);
        map.put("expanation", "坚持就是胜利，“坚持”即为本题中的量的积累，量变引起质变，坚持导致胜利，揭示的是B选项，量变必然引起质变");
        System.out.println(map.toString());
    }
}

