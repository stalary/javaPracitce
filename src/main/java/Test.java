import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(0, 3);
        list.add(0, 2);
        list.add(0, 1);
        System.out.println(list);
    }

}
