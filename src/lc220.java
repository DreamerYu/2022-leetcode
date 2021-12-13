import java.util.TreeSet;

/**
 * @Author: Dreamer Yu
 * @Date: 12/12/21 11:35 AM
 */
public class lc220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Long num = nums[i] * 1L;
            Long small = set.floor(num);
            Long big = set.ceiling(num);

            if(small != null && Math.abs(small - num) <= t*1L) return true;
            if(big != null && Math.abs(big - num) <= t*1L) return true;
            set.add(num);
            if(set.size() > k) set.remove(nums[i - k]*1L);
        }
        return false;
    }
}
