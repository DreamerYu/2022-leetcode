import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 6/15/22 9:33 PM
 */
public class lc719_twodivide {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n =  nums.length;

        int start = 0;
        int end = nums[n-1] - nums[0];

        while(start < end){
            int mid = start + (end - start)/2;

            int count = countlessnums(mid, nums);
            if(count < k){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }


    public int countlessnums(int threshold, int[] nums){

        int count = 0;
        for(int left = 0, right = 0;  right < nums.length; right++){
            while(nums[right] - nums[left] >  threshold){
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
