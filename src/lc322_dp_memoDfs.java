import java.util.Arrays;

/**
 * @Author: Dreamer Yu
 * @Date: 4/24/22 10:18 PM
 */
public class lc322_dp_memoDfs {


    public int coinChange2(int[] coins, int amount) {


        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] == amount+1 ? -1 : dp[amount]);

    }


    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount];
        return dfs(coins, amount);

    }

    public int dfs(int[] coins, int amount){

        if(amount < 0) {
            return -1;
        }

        if(amount == 0){
            return 0;
        }

        if(memo[amount - 1] != 0){
            return memo[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int res = dfs(coins, amount - coins[i]);
            if(res != -1){
                min = Math.min(min, res + 1);
            }
        }

        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];

    }
}
