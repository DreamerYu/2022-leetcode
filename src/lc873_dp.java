import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dreamer Yu
 * @Date: 7/9/22 10:17 PMr
 */
public class lc873_dp {

    public int lenLongestFibSubseq(int[] arr) {

        int res = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0 && j + 2 > res; j--){
                if(arr[i] - arr[j] >= arr[j]) {
                    break;
                }
                int t = map.getOrDefault(arr[i] - arr[j], -1);
                if(t == -1) {
                    continue;
                }
                dp[i][j] = Math.max(3, dp[j][t] + 1);
                res = Math.max(res, dp[i][j]);

            }
        }
        return res;
    }
}
