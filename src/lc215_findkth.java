/**
 * @Author: Dreamer Yu
 * @Date: 12/11/21 10:42 AM
 */
public class lc215_findkth {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        findKthLargest(nums, k);
    }

    public static int findKthLargest(int[] nums, int k) {

        int start = 0, end = nums.length - 1;
        return findkth(0, nums.length - 1, nums, k);
    }

    public static int findkth(int start, int end, int[] nums, int k){
        int s = start;
        int e = end;
        int target = nums[e];

        while(start <= end - 1){
            int b = nums[end - 1];
            if(b > target){
                swap(nums, start, end - 1);
                start++;
            }else{
                end--;
            }
        }
        swap(nums, start, e);
        int p = start-s+1;
        if(p == k){
            return nums[start];
        }else if(p > k){
            return findkth(s, e-1, nums,k);
        }else{
            return findkth(start+1, e, nums, k - p);
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
