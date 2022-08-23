/**
 * @Author: Dreamer Yu
 * @Date: 6/9/22 10:50 AM
 */
public class lc209_prefixsum_2division {

    public int lc209_prefixsum_2division(int target, int[] nums) {

        int n = nums.length;

        int[] sum = new int[n + 1];

        int res = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++){
            sum[i] += nums[i - 1] + sum[i - 1];
        }

        for(int i = 1; i <= n; i++){
            int start = 0;
            int end = i;

            while(start < end){
                int mid = (end + start + 1) / 2;
                if(sum[i] - sum[mid] >= target){
                    start = mid;
                }else{
                    end = mid - 1;
                }
            }

            if(sum[i] - sum[start] >= target){
                res = Math.min(res, i - start);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }
}
