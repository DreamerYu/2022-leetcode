import java.util.Map;
import java.util.Queue;

/**
 * @Author: Dreamer Yu
 * @Date: 7/17/22 10:15 AM
 */
public class lc565_cycle {

    public int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(nums, i));
        }
        return ans;
    }

    private int dfs(int[] nums, int idx) {
        if (nums[idx] == -1) {
            return 0;
        }
        int nxt = nums[idx];
        nums[idx] = -1;
        return 1 + dfs(nums, nxt);
    }

}
