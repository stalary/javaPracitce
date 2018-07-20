import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }
}