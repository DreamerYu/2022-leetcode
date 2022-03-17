/**
 * @Author: Dreamer Yu
 * @Date: 2/12/22 9:00 PM
 */
public class lc162_2fen {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

}
