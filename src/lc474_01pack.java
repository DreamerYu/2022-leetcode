/**
 * @Author: Dreamer Yu
 * @Date: 1/13/22 11:13 PM
 */
public class lc474_01pack {

    public int findMaxForm(String[] strs, int m, int n) {


        int[][] dp = new int[m + 1][ n + 1];

        for(int i = 0; i < strs.length; i++){
            int[] p = count(strs[i]);
            int zero = p[0];
            int one = p[1];

            for(int j = m; j >= zero; j--){
                for(int k = n; k >= one; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }

        }
        return dp[m][n];
    }

    public int[] count(String str){
        int zero = 0;
        int one = 0;
        for(int i = 0; i < str.length(); i++){
            if('1' == str.charAt(i)){
                one++;
            }else{
                zero++;
            }
        }
        return new int[]{zero, one};
    }
}
