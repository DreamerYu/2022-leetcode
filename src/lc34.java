/**
 * @Author: Dreamer Yu
 * @Date: 12/12/21 11:06 AM
 */
public class lc34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];

        res[0] = binaryLeft(nums, target);

        res[1] = binaryright(nums, target);
        return res;
    }

    public int binaryLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left] == target? left : -1;
    }


    public int binaryright(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = (left + right + 1)/2;

            if(target >= nums[mid]){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return nums[left] == target? left : -1;
    }
}
