/**
 * @Author: Dreamer Yu
 * @Date: 7/3/22 4:00 PM
 */
public class contest0703_01_dp {

    public int peopleAwareOfSecret(int n, int delay, int forget) {

        int mod = 1000000007;
        long[] dp = new long[n + 1];

        dp[1] = 1;

        long[] presum = new long[n + 1];
        presum[1] = 1;

        for (int i = 2; i <= n; i++) {
            int left = Math.max(0, i - forget);
            int right = Math.max(0, i - delay);

            long inc = (presum[right] - presum[left] + mod) % mod;
            presum[i] = (presum[i-1] + inc) % mod;
        }

        return (int)((presum[n] - presum[Math.max(0, n - forget)] + mod) % mod);
    }
}
