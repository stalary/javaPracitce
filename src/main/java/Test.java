/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test extends Father{

    public static void main(String[] args) {

    }

    @Override
    void say() {

    }

    @Override
    void see() {

    }
}

abstract class Father {
    private String name;

    private String password;

    abstract void say();

    abstract void see();
}

