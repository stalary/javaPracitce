public class Test {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        boolean interrupted = Thread.interrupted();
        System.out.println(interrupted);
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
    }
}