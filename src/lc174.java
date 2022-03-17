import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 12/4/21 6:13 PM
 */
public class lc174 {

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = Math.max(0, -dungeon[m-1][n-1]);

        for(int i = m-2; i >= 0; i--){
            dp[i][n-1] = Math.max(0, dp[i+1][n-1] - dungeon[i][n-1]);
        }

        for(int i = n-2; i >= 0; i--){
            dp[m-1][i] = Math.max(0, dp[m-1][i+1] - dungeon[m-1][i]);
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j>= 0; j--){
                dp[i][j] = Math.max(0, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0] + 1;


    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
