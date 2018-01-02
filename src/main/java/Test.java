import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[] {
                5,2,3,1,9,6,7,13,22,8,20
        };
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        byte[] bytes = new byte[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bytes[nums[i]] = 1;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

}
