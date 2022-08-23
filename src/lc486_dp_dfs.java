/**
 * @Author: Dreamer Yu
 * @Date: 4/9/22 8:44 PM
 */
public class lc486_dp_dfs {

    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n]; // 表示对于先手人来说在i-j中获得的最大分值

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return dfs(dp, 0, n-1, nums) >= 0;

    }

    public int dfs(int[][] memo, int start, int end, int[] nums){
        if(start > end){
            return 0;
        }

        if(memo[start][end] != Integer.MIN_VALUE){
            return memo[start][end];
        }


        int choseLeft = nums[start] - dfs(memo, start+1, end, nums);
        int choseRight = nums[end] - dfs(memo, start, end - 1, nums);

        memo[start][end] = Math.max(choseLeft, choseRight);
        return memo[start][end];
    }


    public boolean PredictTheWinner2(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n]; // 表示对于先手人来说在i-j中获得的最大分值

        for(int i = 0; i < n; i++){
            dp[i][i] = nums[i];
        }

        for(int j = 1; j < n; j++){
            for(int i = j-1; i >=0; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] >= 0;

    }
}
