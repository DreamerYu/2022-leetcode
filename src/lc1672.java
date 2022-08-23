/**
 * @Author: Dreamer Yu
 * @Date: 4/14/22 4:27 PM
 */
public class lc1672 {

    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) cur += accounts[i][j];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
