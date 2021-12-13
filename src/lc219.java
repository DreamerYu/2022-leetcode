import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: Dreamer Yu
 * @Date: 12/12/21 11:20 AM
 */
public class lc219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
