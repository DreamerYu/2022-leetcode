import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 4/11/22 10:09 PM
 */
public class lc462 {

    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int res  = 0;
        int start = 0;
        int end = nums.length -1;
        while(start < end){
            res += (nums[end--] - nums[start++]);

        }
        return res;
    }

    public int minMoves22(int[] nums) {

        Arrays.sort(nums);

        int mid = nums[nums.length/2];

        int res = 0;

        for(int i = 0; i < nums.length; i++){
            res += Math.abs(mid - nums[i]);
        }

        return res;

    }
}
