import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException, InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lockInterruptibly();
        LockSupport.park();

        String str = "123 ";
        str.trim()
    }


}



