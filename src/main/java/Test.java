import com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.start();
    }
    void start() {
        Two two = new Two();
        System.out.println(two.x + " ");
        Two t2 = fix(two);
        System.out.println(two.x + " " + t2.x);
    }
    Two fix(Two tt) {
        tt.x = 42;
        return tt;
    }
}

class Two {
    Byte x;
}

