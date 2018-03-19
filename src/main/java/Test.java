import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */

public class Test {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        RandomAccessFile aFile = new RandomAccessFile("/Users/mac/test.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
        /*File file = new File("/Users/mac/test.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while ((len = fis.read(buf)) != - 1) {
            sb.append(new String(buf, 0, len, "utf-8"));
        }
        System.out.println(sb.toString());*/
        /*File file = new File("/Users/mac/test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());*/
        System.out.println();
        System.out.println("times:" + (System.currentTimeMillis() - start));
    }
}


