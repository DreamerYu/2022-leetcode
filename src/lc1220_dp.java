import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 1/17/22 9:52 PM
 */
public class lc1220_dp {

    public int countVowelPermutation(int n) {


        int mod = 1000000007;
        long[][] dp = new long[n][5];

        Arrays.fill(dp[0], 1);
        for(int i = 0; i < n - 1; i++){
            // 1.
            dp[i + 1][1] += dp[i][0];
            //2.
            dp[i+1][0] += dp[i][1];
            dp[i+1][2] += dp[i][1];

            //
            dp[i+1][0] += dp[i][2];
            dp[i+1][1] += dp[i][2];
            dp[i+1][3] += dp[i][2];
            dp[i+1][4] += dp[i][2];

            dp[i+1][2] += dp[i][3];
            dp[i+1][4] += dp[i][3];

            dp[i+1][0] += dp[i][4];

            for(int j = 0; j < 5; j++){
                dp[i+1][j] = dp[i+1][j] % mod;
            }
        }
        long res = 0;

        for(int i = 0; i < 5; i++){
            res += dp[n-1][i];
        }
        return (int)(res % mod);
    }
}
