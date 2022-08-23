/**
 * @Author: Dreamer Yu
 * @Date: 4/7/22 10:37 PM
 */
public class lc487_stream_sliding {

    public int findMaxConsecutiveOnes(int[] nums) {

        int first_zero = -1;
        int mid_zero = -1;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(n == 0){
                res = Math.max(res, i - first_zero -1);
                first_zero = mid_zero;
                mid_zero = i;
            }
        }
        res = Math.max(res, nums.length  - first_zero - 1);
        return res;
    }
}
