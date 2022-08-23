import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 4/30/22 7:31 PM
 */
public class lc908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return Math.max(0, max - min - 2 * k);
    }

}
