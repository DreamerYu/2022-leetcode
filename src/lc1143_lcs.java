/**
 * @Author: Dreamer Yu
 * @Date: 6/27/22 10:22 PM
 */
public class lc1143_lcs {

    public int longestCommonSubsequence(String a, String b) {

        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
