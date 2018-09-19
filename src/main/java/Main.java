import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.nextLine();
        String[] strings = next.split(" ");
        List<String> result = Arrays.stream(strings).collect(Collectors.toList());
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (count < 3) {
                if (result.get(i).length() == strings[0].length()) {
                    sb.append(result.get(i)).append(" ");
                    count++;
                }
            } else {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}