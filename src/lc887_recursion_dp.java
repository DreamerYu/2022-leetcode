import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 4/12/22 9:28 PM
 */
public class lc887_recursion_dp {

    public int superEggDrop(int k, int n) {

        int[][] dp = new int[n][n];

        helper2(k, n,dp);
        return dp[k][n];
    }

    public int helper(int k, int n){
        if(n == 1 || n == 0 || k == 1){
            return n;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            min = Math.min(min, 1+Math.max(helper(k-1,i-1), helper(k, n-i)));
        }
        return min;
    }



    public void helper2(int k, int n, int[][] dp){

        if(dp[k][n] != 0) return;

        if(n == 1 || n == 0 || k == 1){
            dp[k][n] = n+1;
            return;
        }

        dp[k][n] = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            if(dp[k-1][i-1] == 0) {
                helper2(k - 1, i - 1, dp);
            }
            if(dp[k][n-1] == 0){
            helper2(k,n-i,dp);
            }
            dp[k][n] = Math.min(dp[k][n], Math.max(dp[k - 1][i - 1], dp[k][n - i]));
        }
    }

    // i 表示k个鸡蛋，j表示目前在几楼
    // dp[i][j] = dp[i-1][aa-1], dp[i][n]

}
