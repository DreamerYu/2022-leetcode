/**
 * @Author: Dreamer Yu
 * @Date: 4/16/22 6:55 PM
 */
public class lc413 {

    public int numberOfArithmeticSlices(int[] nums) {

        if (nums == null || nums.length < 3) return 0;
        int diff = nums[1] - nums[0];
        int count = 2;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                res += count - 1;
                count++;
            } else {
                diff = nums[i] - nums[i - 1];
                count = 2;
            }
        }
        return res;
    }
}
