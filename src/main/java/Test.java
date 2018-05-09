import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws Exception {
        List<String> outList = Arrays.asList("abc", "aaa", "bbb");
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("www");
        set.add("123");
        set.add("bbb");
        System.out.println(outList.containsAll(set));
    }

}


