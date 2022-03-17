/**
 * @Author: Dreamer Yu
 * @Date: 2/15/22 9:54 PM
 */
public class lc474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];

        for(int i = 0; i < strs.length; i++){
            for(char ch : strs[i].toCharArray()){
                if(ch == '0'){
                    count[i][0]++;
                }else{
                    count[i][1]++;
                }
            }
        }

        int[][][] dp = new int[strs.length + 1][m+1][n+1];

        for(int k = 1; k <= strs.length; k++){
            int zero = count[k-1][0];
            int ones = count[k-1][1];
            for(int i = 0; i <= m; i++){
                for(int j = 0; j <= n; j++){
                    dp[k][i][j] = Math.max(dp[k-1][i][j], (i >= zero && j >= ones) ? dp[k-1][i-zero][j-ones] + 1: 0);
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];

        for(int i = 0; i < strs.length; i++){
            for(char ch : strs[i].toCharArray()){
                if(ch == '0'){
                    count[i][0]++;
                }else{
                    count[i][1]++;
                }
            }
        }

        int[][] dp = new int[m+1][n+1];

        for(int k = 1; k <= strs.length; k++){
            int zero = count[k-1][0];
            int ones = count[k-1][1];
            for(int i = m; i >= 0; i--){
                for(int j = n; j>=0; j--){
                    dp[i][j] = Math.max(dp[i][j], (i >= zero && j >= ones) ? dp[i-zero][j-ones] + 1: 0);
                }
            }
        }
        return dp[m][n];
    }
}
