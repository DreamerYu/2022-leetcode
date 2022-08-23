/**
 * @Author: Dreamer Yu
 * @Date: 6/17/22 9:55 PM
 */
public class lc1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            dp[i] = -1;
        }

        dp[0]  = arr[0];
        for(int i  = 1; i < arr.length; i++){
            int max = arr[i];
            dp[i] = dp[i-1] + arr[i];
            for(int j = i; j >= Math.max(0, i-k+1); j--){
                max = Math.max(max, arr[j]);
                if(j == 0){
                    dp[i] = Math.max(dp[i], (i+1)*max);
                }else{
                    dp[i] = Math.max(dp[i], dp[j-1] + max*(i - j  + 1));
                }
            }
        }
        return dp[arr.length - 1];
    }
}
