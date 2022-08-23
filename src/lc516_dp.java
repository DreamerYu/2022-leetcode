/**
 * @Author: Dreamer Yu
 * @Date: 6/10/22 3:32 PM
 */
public class lc516_dp {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        char[] chs = s.toCharArray();

        int[][] dp = new int[n][n];

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j >= 0; j--){
                if(i == j){
                    dp[j][i] = 1;
                }else if(i - j == 1){
                    dp[j][i] = (chs[j] == chs[i]? 2 : 1);
                }else{
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
                    dp[j][i] = Math.max(dp[j][i], dp[j+1][i-1] + (chs[j] == chs[i]? 2 : 0));
                }
            }
        }
        return dp[0][n-1];
    }
}
