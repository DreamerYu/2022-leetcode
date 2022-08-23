/**
 * @Author: Dreamer Yu
 * @Date: 3/31/22 7:26 PM
 */
public class lc494_package {


    public int findTargetSumWays(int[] nums, int target) {


        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += Math.abs(nums[i]);
        }
        if (Math.abs(target) > s) return 0;

        int[][] dp = new int[nums.length + 1][2*s + 1];
        dp[0][s] = 1;

        for(int i = 0; i < nums.length; i++){
            int x = nums[i];

            for(int j = -s; j <= s; j++){
                if(j - x + s >= 0){
                    dp[i + 1][j + s] = dp[i + 1][j+s] + dp[i][j -x + s];
                }

                if(j + x + s <= 2*s){
                    dp[i+1][j+s] += dp[i][j + x + s];
                }
            }
        }
        return dp[nums.length][target + s];
    }
}
