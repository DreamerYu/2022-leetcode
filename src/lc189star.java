import java.util.ArrayList;

/**
 * @Author: Dreamer Yu
 * @Date: 12/3/21 1:12 PM
 */
public class lc189star {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;

        }
    }


    public void rotate2(int[] nums, int k){

    }

}
