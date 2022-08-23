import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 4/7/22 9:15 PM
 */
public class lc1751_package {

    public int maxValue(int[][] events, int k) {



        int[][] dp = new int[events.length+1][k+1];

        Arrays.sort(events, (a,b) -> (a[1]-b[1]));

        for(int i = 1; i <= events.length; i++){
            int[] e = events[i-1];

            int start = e[0];
            int end = e[1];
            int value = e[2];

            int last = 0;
            for(int m = i-1; m >= 0; m--){
                if(events[m][1] < start){
                    last = m+1;
                    break;
                }
            }

            for(int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[last][j-1] + value);
            }

        }

        return dp[events.length][k];
    }
}
