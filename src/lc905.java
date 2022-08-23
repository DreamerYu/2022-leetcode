/**
 * @Author: Dreamer Yu
 * @Date: 4/28/22 11:07 AM
 */
public class lc905 {

    public int[] sortArrayByParity(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            while(start < end && nums[start] % 2 == 0){
                start++;
            }
            while(start <= end && nums[end] % 2 == 1){
                end--;
            }

            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return nums;
    }
}
