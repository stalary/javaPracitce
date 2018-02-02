import java.io.IOException;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Test t = new Test();
        System.out.println(Integer.valueOf("2"));
    }


    public void test() {
        try {
            System.out.println(this.getClass().getClassLoader().getResources(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



