/**
 * @Author: Dreamer Yu
 * @Date: 6/26/22 2:57 PM
 */
public class contest220626_02 {

    public int countHousePlacements(int n) {

        int ee = 1000000007;

        int[][] dp = new int[n+1][2];

        dp[0][0] = 1;

        for(int i = 1; i <= n; i++){
            dp[i][1] = dp[i-1][0];
            dp[i][0] = (dp[i-1][1] + dp[i-1][0]) % ee;
        }

        int res = ((dp[n][0] + dp[n][1])*(dp[n][0] + dp[n][1])) % ee;

        return res;
    }
}
