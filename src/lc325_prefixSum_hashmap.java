import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 4/30/22 9:23 PM
 */
public class lc325_prefixSum_hashmap {

    public int maxSubArrayLen(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int remain = sum - k;
            if(map.containsKey(remain)){
                max = Math.max(max, i - map.get(remain));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                map.put(sum, Math.min(i, map.get(sum)));
            }
        }
        return max;
    }
}
