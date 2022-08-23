/**
 * @Author: Dreamer Yu
 * @Date: 8/23/22 10:13 PM
 */
public class lc2016 {


    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int res = -1;
        for(int i = 1; i < nums.length; i++){
            res = Math.max(res, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return res == 0? -1 : res;
    }
}
